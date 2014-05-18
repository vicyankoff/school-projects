#Program that plays Hangman based on Beatles Songs
#author: Viktor Jankov

import random
import sys

#enumerated data type for the different
#states that the graphics of the game fall into
HANGMANS = ['''

  +---+
  |   |
      |
      |
      |
      |
=========''', '''

  +---+
  |   |
  O   |
      |
      |
      |
=========''', '''

  +---+
  |   |
  O   |
  |   |
      |
      |
=========''', '''

  +---+
  |   |
  O   |
  |   |
  |   |
      |
=========''', '''

  +---+
  |   |
 oOo  |
 /|\  |
  |   |
      |
=========''', '''

  +---+
  |   |
 oOo  |
 /|   |
  |   |
      |
=========''', '''

  +---+
  |   |
 oOo  |
 /|\  |
  |   |
      |
=========''','''

  +---+
  |   |
 oOo  |
 /|\  |
  |   |
 /    |
=========''','''

  +---+
  |   |
 oOo  |
 /|\  |
  |   |
 / \  |
=========''']


#Introduction to the game, and spells out the rules for playing
def introduction():
    print("Let's play hangman! I will pick a secret Beatles Song.")
    print("On each turn, you guess a letter. If the letter is")
    print("in the song, I will show you where it appears.")
    print("You only get 8 incorrect guesses. Good luck.")
    print("You can guess more letters at once, but remember, ")
    print("if the string doesn't exactly match parts of the song,")
    print("you loose that many guesses.")


#Main function which instantiates all the variables
#Loops through the program until there are no more guesses left 
#or until the player has won.
#this function also gets input from the user and keeps track of the mentioned letters 

def hangman():
    introduction()
    song = getSong()
    #print(song)
    guesses = 8
    hangmanPic = 1
    mentioned = []
    secretWord = updateWord(song,mentioned)
    while guesses >= 1:
        print(HANGMANS[8 - guesses])
        print("Secret word: ", secretWord)
        print("You have " , guesses, " guesses left.")
        print("Letters guessed: ")

        for a in mentioned:
            sys.stdout.write("\r%s" % a)
            sys.stdout.flush()
        sys.stdout.write("\n")
        
        player = getInput(mentioned)
        mentioned.append(player.upper())

        if checkLetter(song,player):
            print("You got it!")
            print("")
            secretWord = updateWord(song,mentioned)
            if(checkWinner(secretWord, song) == True):
                print("Secret word: ", song)
                print("Congratulations, you guessed the wright word!")
                print("And you only had ",  8 - guesses, ", wrong guesses")
                return 
        else:
            print("I'm sorry but there are no ", player.upper(), "'s in the song")
            print("")
            if len(player) > 1:
                guesses -= len(player)
                
            else:
                guesses -= 1
             

    print("You lose! The word was: ", song)
    return
    
#function which returns the title of a song
#randomly chosen from a text file of the Beatles Discography        
def getSong():
    songList = [line.strip() for line in open('beatlesSongs')]
    song =(random.choice(songList))
    return song

#fuction that updates the secret word
#if a letter is contanined, it prints it, oterwise it prints '-'
def updateWord(song, mentioned):
    text = ''
    for c in song:
        if c.isalpha():
            if any(c.lower() in m.lower() for m in mentioned):
                text += c
            else:
                text += "- "
        else:
            text += c
    return text


def printStart(song):
    for c in song:
        if c.isalpha():
            sys.stdout.write("- ")
        else:
            sys.stdout.write(c)
    
#check if a letter is present in the song title and return true if it is, false otherwise
def checkLetter(song, player):
    if len(player) > 1:
        if player in song:
            return True
        else:
            return False
    for c in song:
        if c.lower() == player.lower():
            return True
    return False

#get the input from the player and check for legality
#if the input is not a letter loop until correct input is entered and return that 
def getInput(mentioned):
    exit = False
    while True:
        player = input("Your guess: ")
        #if any(player.lower() in m.lower() for m in mentioned):
        for m in mentioned:
            if player.lower() == m.lower():
                print("You already mentioned ", player.upper(), ", go again!")
                exit = True
                continue
        if exit == True:
            exit = False
            continue
        if not(player.isalpha()):
           print("This is not a letter, and only letters are allowed")
           continue
        else:
           return player
#check if the entire word is guessed, return true if it is, otherwise return false
def checkWinner(secretWord, song):
    if (secretWord == song):
        return True
    else:
        return False
           
hangman()
print("")
#loop that prompts the user whether s/he want's to play more or stop playing hangman
while True:
    playAgain=input("Would you like to play again: Y or N: ")
    if playAgain.lower() == 'y':
        print("")
        hangman()
    else:
        break
