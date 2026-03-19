/**
 * Sticky Note Pad library class for KIT107 Lab 4.
 *
 * @author Julian Dermoudy and <<INSERT NAME HERE>>
 * @version <<INSERT DATE HERE>>
 */

public class StickyNotePad {
    private String[] pad; // array of strings for note pad
    private int currentIndex; // index of current (displayed) note
    private int currentSize; // number of elements in use

    /**
     * Constructor
     * Instantiates array, and initialises current index and current
     * usage count to 0
     * 
     * @param size number of elements in array
     */
    public StickyNotePad(int size) {
        // instantiate array
        pad = new String[size];
        // initialise other instance variables to zero
        currentIndex = 0;
        currentSize = 0;

    }

    /**
     * isFull
     * Check whether note pad is currently full, returning true if
     * so and false otherwise
     * 
     * @return boolean of whether note pad is full.
     */
    public boolean isFull() {
        return currentSize == pad.length;
    }

    /**
     * isEmpty
     * Check whether note pad is currently empty, returning true
     * if so and false otherwise
     * 
     * @return boolean of whether note pad is empty.
     */
    public boolean isEmpty() {
        return currentSize == 0;
    }

    /**
     * addNote
     * Create a new note by moving to the end of the used portion
     * of the array, expanding the used portion by incrementing
     * currentSize, and adding the given String to the new last
     * element. If the array is full then an
     * ArrayIndexOutOfBoundsException object is created and
     * thrown.
     * 
     * @param n contents of new note
     */
    public void addNote(String n) {
        // if note pad isn't full...
        if (!isFull()) {
            // move current index to new last note
            currentIndex = currentSize;
            // increment size of used portion of array
            pad[currentSize] = n;
            currentSize++;
            // store n in current element of note pad

        } else {
            throw new ArrayIndexOutOfBoundsException("Note pad is full.");
        }
    }

    /**
     * deleteNote
     * Delete current note, moving all later notes down in the
     * array to overwrite the current one. If there are no
     * notes then don't do anything.
     */
    public void deleteNote() {
        if (!isEmpty()) {
            // Shift elements to overwrite the current note
            for (int i = currentIndex; i < currentSize - 1; i++) {
                pad[i] = pad[i + 1];
            }

            // Decrement count of used portion of array
            currentSize--;

            // If note pad is now empty, reset index to 0
            if (isEmpty()) {
                currentIndex = 0;
            }
            // If the deleted note was the last one, move index back to the new last note
            else if (currentIndex >= currentSize) {
                currentIndex = currentSize - 1;
            }
        }
    }

    /**
     * getNote
     * Examine current sticky note and return its contents
     * prefaced by "NOTE x OF y.". If there are no notes in
     * the sticky note pad then "" is returned.
     * 
     * @return String printable version of sticky note contents
     */
    public String getNote() {
        String ans;

        if (isEmpty()) {
            ans = "";
        } else {
            // NOTE x OF y.\n\n plus contents.
            // We use (currentIndex + 1) because arrays are 0-indexed but users expect
            // 1-indexed.
            ans = "NOTE " + (currentIndex + 1) + " OF " + currentSize + ".\n\n" + pad[currentIndex];
        }

        return ans;
    }

    /**
     * nextNote
     * Move current note index to next note in note pad (stopping
     * at last note).
     */
    public void nextNote() {
        // Increment current note index
        currentIndex++;

        // Readjust current index to end of used portion (last valid index is
        // currentSize - 1)
        if (currentIndex >= currentSize) {
            currentIndex = currentSize - 1;
        }

        // Safety check for empty pad
        if (currentIndex < 0) {
            currentIndex = 0;
        }
    }

    /**
     * previousNote
     * Move current note index to previous note in note pad (stopping
     * at first note).
     */
    public void previousNote() {
        // decrement current note index
        currentIndex--;
        // readjust current index to start of used portion if necessary
        if (currentIndex < 0) {
            currentIndex = 0;
        }
    }
}