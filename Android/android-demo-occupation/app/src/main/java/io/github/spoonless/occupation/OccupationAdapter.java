package io.github.spoonless.occupation;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class OccupationAdapter extends RecyclerView.Adapter<OccupationAdapter.OccupationViewHolder> {

    public static class OccupationViewHolder extends RecyclerView.ViewHolder {
        private View content;
        private Occupation occupation;

        public OccupationViewHolder(View content) {
            super(content);
            this.content = content;
            this.content.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), OccupationActivity.class);
                    intent.putExtra("occupationId", occupation.getId());
                    intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                    v.getContext().startActivity(intent);
                }
            });
        }

        public void setOccupation(Occupation occupation) {
            this.occupation = occupation;
            TextView textView = this.content.findViewById(R.id.nomOccupation);
            textView.setText(this.occupation.getNom());
            // On extrait l'identifiant de ressource correspondant à l'icône.
            int imageId = this.content.getResources().getIdentifier("ic_categorie_" + this.occupation.getCategorie(), "drawable", this.content.getContext().getPackageName());
            if (imageId == 0) {
                imageId = R.drawable.ic_categorie_defaut;
            }
            // On positionne l'image à gauche du libellé du texte.
            textView.setCompoundDrawablesWithIntrinsicBounds(imageId, 0, 0, 0);
        }
    }

    private List<Occupation> occupations;

    public OccupationAdapter(List<Occupation> occupations) {
        this.occupations = occupations;
    }

    @NonNull
    @Override //Comment ca s'afficher (Layout) ?
    public OccupationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.occupation_view, parent, false);
        return new OccupationViewHolder(view);
    }

    @Override //Quelles données a affichée ?
    public void onBindViewHolder(@NonNull OccupationViewHolder viewHolder, int position) {
        viewHolder.setOccupation(occupations.get(position));
    }

    @Override //Combien d'item a afficher ?
    public int getItemCount() {
        return occupations.size();
    }
}
