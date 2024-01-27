fun main() {
    var contactList = mutableListOf<Contact>()
    var isValidChoice = false

    while (!isValidChoice) {
        printMenu()
        val choice = readLine()?.toIntOrNull()

        when (choice) {
            1 -> {
                option1(contactList)
                isValidChoice = false
            }
            2 -> {
                option2(contactList)
                isValidChoice = false
            }
            3 -> {
                option3(contactList)
                isValidChoice = false
            }
            4 -> {
                option4(contactList)
                isValidChoice = false
            }
            5 -> {
                option5(contactList)
                isValidChoice = false;
            }
            6 -> {
                option6()
                isValidChoice = true
            }
            else -> println("Invalid choice. Please choose a number between 1 and 5.")
        }
    }
}
fun printMenu() {
    println("Select an option:")
    println("1. Add contact")
    println("2. View contacts")
    println("3. Change a contact")
    println("4. Search for a contact")
    println("5. Remove a contact")
    println("6. Quit the program")
}
fun option1(contactList: MutableList<Contact>) {
    println("You selected Option 1.")
    print("First name: ")
    var first = readLine();
    println()
    print("Last name: ")
    var last = readLine();
    println()
    print("Phone number: ")
    var phone = readLine();
    var newContact = Contact(first, last, phone)
    contactList.add(newContact)

}
fun option2(contactList: MutableList<Contact>) {
    println("You selected Option 2.")
    if (contactList.isNotEmpty()) {
        val sortedContacts = contactList.sortedBy { it._first }
        println("Contacts in alphabetical order:")
        sortedContacts.forEachIndexed { index, contact ->
            println("${index + 1}. Name: ${contact._first} ${contact._last},  Phone Number: ${contact._phone}")
        }
        println()
    } else {
        println("No contacts available." +
                "\nPlease make another choice.")
        println()
    }

}
fun option3(contactList: MutableList<Contact>) {
    println("You selected Option 3.")
    if (contactList.isNotEmpty()) {
        println("Select a contact to modify:")
        contactList.forEachIndexed { index, contact ->
            println("${index + 1}. Name: ${contact._first} ${contact._last}, Phone Number: ${contact._phone}")
        }

        val selectedIndex = readLine()?.toIntOrNull()?.minus(1)

        if (selectedIndex in 0 until contactList.size) {
            var selectedContact = contactList[selectedIndex!!]

            println("\nModify contact:")
            print("New First Name (current: ${selectedContact._first}): ")
            var newFirst = readLine() ?: selectedContact._first

            print("New Last Name (current: ${selectedContact._last}: ")
            var newLast = readLine() ?: selectedContact._last

            print("New Phone Number (current: ${selectedContact._phone}): ")
            var newPhoneNumber = readLine() ?: selectedContact._phone

            selectedContact.apply {
                _first = newFirst
                _last = newLast
                _phone = newPhoneNumber
            }

            println("\nContact modified successfully:")
            println("Name: $newFirst $newLast, Phone Number: $newPhoneNumber")
        } else {
            println("Invalid selection. No contact modified.")
        }
    } else {
        println("No contacts available to modify.")
    }
}
fun option4(contactList: MutableList<Contact>) {
    println("You selected Option 4.")
    println("Enter search term:")
    val searchTerm = readLine()?.toLowerCase() ?: ""

    val searchResults = contactList.filter {
        it._first!!.toLowerCase().contains(searchTerm) ||
                it._last!!.toLowerCase().contains(searchTerm) ||
                it._phone!!.toLowerCase().contains(searchTerm)
    }

    if (searchResults.isNotEmpty()) {
        println("Search results:")
        searchResults.forEachIndexed { index, contact ->
            println("${index + 1}. Name: ${contact._first} ${contact._last}, Phone Number: ${contact._phone}")
        }
    } else {
        println("No matching contacts found.")
    }
}
fun option5(contactList: MutableList<Contact>) {
    println("You selected Option 5.")
    if (contactList.isNotEmpty()) {
        println("Select a contact to remove.")
        contactList.forEachIndexed { index, contact ->
            println("${index + 1}. Name: ${contact._first} ${contact._last}, Phone Number: ${contact._phone}")
        }
        val selectedIndex = readLine()?.toIntOrNull()?.minus(1)
        if (selectedIndex in 0 until contactList.size) {
            val removedContact = contactList.removeAt(selectedIndex!!)
            println("\nContact removed successfully:")
            println("Name: ${removedContact._first} ${removedContact._last}, Phone Number: ${removedContact._phone}")
        } else {
            println("Invalid selection. No contact removed.")
        }
    } else {
        println("No contacts available to remove.")
    }
    println()
}
fun option6() {
    println("You selected Option 6.")
    print("Exiting the program.")
    return;

}

