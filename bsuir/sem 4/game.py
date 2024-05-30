import pygame
import random
import json
import sys
from pygame.locals import *

pygame.init()

# Constants
WIDTH, HEIGHT = 800, 600
WHITE = (255, 255, 255)
BLACK = (0, 0, 0)
FONT_SIZE = 32
WORD_LIST = ['PYTHON', 'HANGMAN', 'DEVELOPER', 'PROGRAMMING']
RECORDS_FILE = 'records.json'
TIME_LIMIT = 20  # Time limit in seconds

# Initialize screen
screen = pygame.display.set_mode((WIDTH, HEIGHT))
pygame.display.set_caption('Hangman Game')
font = pygame.font.Font(None, FONT_SIZE)

# Load assets
background_music = pygame.mixer.Sound('background_music.mp3')
correct_sound = pygame.mixer.Sound('correct.mp3')
wrong_sound = pygame.mixer.Sound('wrong.mp3')
background_music.play(-1)


# Helper functions
def load_records():
    try:
        with open(RECORDS_FILE, 'r') as f:
            return json.load(f)
    except FileNotFoundError:
        return []


def save_records(records):
    with open(RECORDS_FILE, 'w') as f:
        json.dump(records, f)


def draw_text(text, font, color, surface, x, y):
    textobj = font.render(text, 1, color)
    textrect = textobj.get_rect()
    textrect.topleft = (x, y)
    surface.blit(textobj, textrect)


def main_menu():
    while True:
        screen.fill(WHITE)
        draw_text('Hangman Game', font, BLACK, screen, 20, 20)
        draw_text('1. Start Game', font, BLACK, screen, 20, 100)
        draw_text('2. High Scores', font, BLACK, screen, 20, 150)
        draw_text('3. Help', font, BLACK, screen, 20, 200)
        draw_text('4. Quit', font, BLACK, screen, 20, 250)

        for event in pygame.event.get():
            if event.type == QUIT:
                pygame.quit()
                sys.exit()
            if event.type == KEYDOWN:
                if event.key == K_1:
                    game()
                if event.key == K_2:
                    high_scores()
                if event.key == K_3:
                    help_screen()
                if event.key == K_4:
                    pygame.quit()
                    sys.exit()

        pygame.display.update()


def help_screen():
    while True:
        screen.fill(WHITE)
        draw_text('Help - Hangman Rules', font, BLACK, screen, 20, 20)
        draw_text('1. Guess the word by choosing letters.', font, BLACK, screen, 20, 100)
        draw_text('2. You have limited attempts to guess the word.', font, BLACK, screen, 20, 150)
        draw_text('3. Each wrong guess brings you closer to losing.', font, BLACK, screen, 20, 200)
        draw_text('4. You have 20 seconds to guess the word.', font, BLACK, screen, 20, 250)
        draw_text('Press any key to return to the main menu.', font, BLACK, screen, 20, 300)

        for event in pygame.event.get():
            if event.type == QUIT:
                pygame.quit()
                sys.exit()
            if event.type == KEYDOWN:
                return

        pygame.display.update()


def high_scores():
    records = load_records()
    while True:
        screen.fill(WHITE)
        draw_text('High Scores', font, BLACK, screen, 20, 20)
        y_offset = 100
        for record in records:
            draw_text(f'{record["name"]}: {record["attempts"]} attempts', font, BLACK, screen, 20, y_offset)
            y_offset += 50
        draw_text('Press any key to return to the main menu.', font, BLACK, screen, 20, y_offset + 50)

        for event in pygame.event.get():
            if event.type == QUIT:
                pygame.quit()
                sys.exit()
            if event.type == KEYDOWN:
                return

        pygame.display.update()


def game():
    word = random.choice(WORD_LIST)
    guessed = ['_'] * len(word)
    attempts = 0
    max_attempts = 6
    used_letters = []
    start_time = pygame.time.get_ticks()  # Get the start time in milliseconds

    while True:
        screen.fill(WHITE)
        elapsed_time = (pygame.time.get_ticks() - start_time) // 1000  # Calculate elapsed time in seconds
        remaining_time = TIME_LIMIT - elapsed_time

        if remaining_time <= 0:
            end_game(False, word, attempts)
            return

        draw_text(f'Word: {" ".join(guessed)}', font, BLACK, screen, 20, 20)
        draw_text(f'Attempts: {attempts}', font, BLACK, screen, 20, 100)
        draw_text(f'Used Letters: {", ".join(used_letters)}', font, BLACK, screen, 20, 150)
        draw_text(f'Time Left: {remaining_time} seconds', font, BLACK, screen, 20, 200)

        for event in pygame.event.get():
            if event.type == QUIT:
                pygame.quit()
                sys.exit()
            if event.type == KEYDOWN:
                if event.unicode.isalpha():
                    letter = event.unicode.upper()
                    if letter in used_letters:
                        continue
                    used_letters.append(letter)
                    if letter in word:
                        correct_sound.play()
                        for i, char in enumerate(word):
                            if char == letter:
                                guessed[i] = letter
                    else:
                        wrong_sound.play()
                        attempts += 1
                    if attempts >= max_attempts:
                        end_game(False, word, attempts)
                        return
                    if '_' not in guessed:
                        end_game(True, word, attempts)
                        return

        pygame.display.update()


def end_game(won, word, attempts):
    if won:
        records = load_records()
        if len(records) < 10 or attempts < records[-1]['attempts']:
            name = get_player_name()
            if name:
                new_record = {"name": name, "attempts": attempts}
                records.append(new_record)
                records = sorted(records, key=lambda x: x['attempts'])[:10]
                save_records(records)
                congrats_animation(name, attempts)
                return
    else:
        show_end_message(won, word, attempts)


def get_player_name():
    name = ''
    entering_name = True
    while entering_name:
        screen.fill(WHITE)
        draw_text('You set a new high score!', font, BLACK, screen, 20, 20)
        draw_text('Enter your name: ' + name, font, BLACK, screen, 20, 100)
        draw_text('Press Enter to save.', font, BLACK, screen, 20, 150)

        for event in pygame.event.get():
            if event.type == QUIT:
                pygame.quit()
                sys.exit()
            if event.type == KEYDOWN:
                if event.key == K_RETURN:
                    entering_name = False
                elif event.key == K_BACKSPACE:
                    name = name[:-1]
                else:
                    if len(name) < 20:
                        name += event.unicode

        pygame.display.update()
    return name


def congrats_animation(name, attempts):
    frames = 60
    for i in range(frames):
        screen.fill(WHITE)
        draw_text(f'Congratulations, {name}!', font, BLACK, screen, 20, 20 + i * 2)
        draw_text(f'New high score: {attempts} attempts', font, BLACK, screen, 20, 100 + i * 2)
        pygame.display.update()
        pygame.time.delay(50)
    wait_for_key()
    main_menu()


def show_end_message(won, word, attempts):
    while True:
        screen.fill(WHITE)
        if won:
            draw_text('You won!', font, BLACK, screen, 20, 20)
        else:
            draw_text('You lost!', font, BLACK, screen, 20, 20)
        draw_text(f'The word was: {word}', font, BLACK, screen, 20, 100)
        draw_text(f'Your attempts: {attempts}', font, BLACK, screen, 20, 150)
        draw_text('Press any key to return to the main menu.', font, BLACK, screen, 20, 200)

        for event in pygame.event.get():
            if event.type == QUIT:
                pygame.quit()
                sys.exit()
            if event.type == KEYDOWN:
                return

        pygame.display.update()


def wait_for_key():
    while True:
        for event in pygame.event.get():
            if event.type == QUIT:
                pygame.quit()
                sys.exit()
            if event.type == KEYDOWN:
                return


main_menu()
