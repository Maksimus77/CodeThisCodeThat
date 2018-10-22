import random

# Helper functions
def create_array():
    # This is where the array will be created
    print("Creating the array...")
    length_of_array = 21
    new_array = [0]*length_of_array # initialise the whole array the 0
    print("Done Creating the array!")
    return new_array

def bounce():
    # This will either return 1 or -1
    random_number = 2 * random.randint(0, 1) - 1
    return random_number

def drop():
    # This function will determine where the ball should land
    print("Starting simulation of dropping one ball...")
    current_slot = 0
    number_bounce_left = 10
    # Simulating 10 bounces
    while number_bounce_left != 0:
        current_slot = current_slot + bounce()  # this will do a + or - 1
        number_bounce_left = number_bounce_left - 1  # decrement number of bounce
    print("Simulation Terminated!")
    # Finally we will return i + 10 because our array is of size 21 an current_slot is ranging from -10 to 10
    return current_slot + 10

def collect(balls,count):
    # This will simulate the droping of X number of Balls and store them in count (which is our array)
    print("Starting simulation of dropping many balls...")
    # Dropping X number of balls
    for i in range(balls):
        slot_ball_falled = drop()
        count[slot_ball_falled] = count[slot_ball_falled] + 1  # increment count at this index because the ball falled there
    print("Simulation Terminated")
    return count

def build_line(number,balls):
    # This will create one line of the full histogram
    # Creating one line of the histogram...
    line = str(number) + '\t'
    for i in range(balls):
        line += 'o'
    # Done Creating one line of histogram!
    return line

def display(count):
    # This will display the entire histogram
    print("Starting to create the histogram...")
    for i in range(-10,11):
        print(build_line(i,count[i + 10]))
    print("Done drawing the histogram!")


def main():
    # This is where your program start
    print("Launching the Program...")
    current_seed = 1 # for the random number generator
    random.seed(current_seed)  # Seeding the random number generator for reproducible testing
    number_balls = int(input("Enter a number of balls to drop: "))  # here we assume the input will be an int
    # Simulating the whole balls drop thing
    count = create_array()
    count = collect(number_balls,count)
    display(count)
    print("Program Terminated!")


# We start the program by calling up the main function
main()