# Algorithm to generate a random number
# These algo's are all big O(1) runtime and space complexity


# Time will be a good random seed
# cause it is not constant
import time

# store the current milliseconds
startTime = time.perf_counter()

# convert it into a whole number (an integer)
randomSeed = int(startTime * 1000)
# randomSeed = 1234

# The function that returns a random value
def radom_val():

    # Using the randomSeed variable locally
    global randomSeed
    result = randomSeed

    # result takes the value into a binary form
    # and shift it either left or right, n times.
    # "<<" is shift left ">>" is shift right
    # i.e.: 2 << 3 is equal to 10000
    result ^= result << 13;
    result ^= result >> 17;
    result ^= result << 5;

    # we update the randomSeed in order to
    # generate a different random number
    # on the next call.
    randomSeed = result

    return result


# Range function takes the minimum and maximum value
# and returns a value in that range

def randomRange(min, max):

    # the range is between the maximum and minimum
    # add 1 to prevent it form being equal to zero
    # more conditions can be added to improve this.
    range = max - (min + 1)

    # the random algorithm modulo(%) the range
    # result in a value in the range provided.
    result = radom_val() % range
    result -= min
    return result

print("random_val algo returns: " + str(radom_val())
# print(radom_val())
# print(radom_val())

print("random value between 0 and 100 is: "+ str(randomRange(0,100)))
# print(randomRange(0,100))
# print(randomRange(0,100))
# print(randomRange(0,100))
# print(randomRange(0,100))
# print(randomRange(0,100))


# using the linear congruential generator
# we must use defined values for the modulus, a, and c
# the seed could be defined once and we just
# keep calling the function since yield allows us to go until we're tired

def lcg(modulus=4294967295, a=1664525, c=1013904223,seed= 2):
    while True:
        seed = (a * seed + c) % modulus
        yield seed

gen = lcg()
print(next(gen))
print(next(gen))
print(next(gen))
