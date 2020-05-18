# SSH creation

## Generation de la clé

Saisir la commande suivante dans un terminal :

```
ssh-keygen -t ed_25519 -b 4096 -C "votrenom_key"
```

Faire `entrer` pour conserver le chemin et le nom par defaut

Vous avez la possibilité d'ajouter un mot de passe sur votre clé ssh, faire `entrer` si vous ne voulez pas en mettre, puis encore `entrer` pour confirmer

## composition de la clé

Dans votre répertoire utilisateur, vous avez un repertoire caché .ssh dans lequel vous avez un fichier .pub

Le fichier `id_ed25519.pub` est votre clé publique, contenu que vous pouvez partager

l'autre fichier `id_ed25519` est votre clé privée, à conserver secret

## Configuratin personalisé

Ajouter un fichier `config` dans le dossier `.ssh`

```
host gitlab                         # le nom que vous souaitez
  Hostname gitlab.com               # l'adresse du service, ex: 10.5.26.54 ou mondomaine.com
  User votreuser                    # l'utilisateru utilisé pour se connecter
  IdentityFile ~/.ssh/id_ed25519    # la reference à la clé utilisé
```