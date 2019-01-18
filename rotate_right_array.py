# Deogratias Amani
# Array rotating to the right approach number (N)

# The question was: Given an array, rotate the array to the right by k steps, where k is non-negative.


def rotate_array():
    # My Sample Array
    array = [10, 20, 30, 40, 50, 60, 70, 80, 90, 100]

    # Number of times to rotate the array (k - steps)
    k_times = 3

    # In case K_times is greater/lesser than the array length then do the following.
    if k_times != len(array):
        k_times = k_times % len(array)  # the remainder will be the number of times the array will rotate

        print('\nprevious array', array, '\n')
        array = array[-k_times:len(array)] + array[0:-k_times]

    else:
        print("\nThe array length equals the k rotation times\n")

    print(array)


rotate_array()


