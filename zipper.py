import zipfile
import os

ZIP_NAME = 'b2220356127'

files = [
    'DiceGame.java',
    'GameManager.java',
    'RoundManager.java',
    'Messages.java',
    ]

# create src folder
os.system('mkdir src')

# copy them to src folder
for file in files:
    os.system(f'cp {file} src/')

# zip all src folder
with zipfile.ZipFile(f'{ZIP_NAME}.zip', 'w') as zipf:
    for root, dirs, files in os.walk('src'):
        for file in files:
            zipf.write(os.path.join(root, file))
        
# remove src folder
os.system('rm -r src')