import java.util.Scanner;

public class searchNsort
{
	static Scanner sc = new Scanner(System.in);
	public static void main(String args[])
	{
		int choice;
		 do {
			System.out.println("\t\t\t----------   Search N Sort   ----------\n");
            System.out.println("-----------  Choose a operation that you want to perform on the strings  -----------\n");
            System.out.println("\t\t\t\t1. Bubble Sort");
            System.out.println("\t\t\t\t2. Selection Sort");
            System.out.println("\t\t\t\t3. Linear Search");
            System.out.println("\t\t\t\t4. Binary search");
            System.out.println("\t\t\t\t5. Exit\n");

            System.out.print("-------------------------\tEnter your choice\t------------------------\n");
            System.out.print("-----------   ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    Bsort();
                    break;
                case 2:
                    Ssort();
                    break;
                case 3:
                    Lsearch();
                    break;
				case 4:
					Bsearch();
					break;
				case 5:
                    System.exit(0);
                    break;
				default:
					System.out.println("-------------------------\tEnter a valid choice\t------------------------\n");
                    break;
			}
        } while (choice != 5);
	}
	public static void Bsort() {
        String temp;
        int n;
        System.out.println("  \t\t\t----------   Bubble Sort   ----------\t\t\t\t");
        System.out.println("--------------------------------------------------------------------------------\n\n");
        System.out.print("----------   Enter number of strings: ");
        n = sc.nextInt();
        sc.nextLine();
        String[] name = new String[n];
        System.out.println("----------   Enter strings:");
        for (int i = 0; i < n; i++) {
            System.out.print("----------   String " + (i + 1) + ": ");
            name[i] = sc.nextLine();
        }
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n - i-1; j++) {
                if (name[j].compareTo(name[j + 1]) > 0) {
                    temp = name[j];
                    name[j] = name[j + 1];
                    name[j + 1] = temp;
                }
            }
        }
        System.out.println("\n\t\t----------   The strings after sorting    ----------\n");
        System.out.print("----------   ");
        for (int i = 0; i < n; i++) {
            System.out.print(name[i] + "  ");
        }
        System.out.println("\n--------------------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------------------\n");
    }
	public static void Ssort() 
	{
		int n;
		//Scanner scanner = new Scanner(System.in);
		System.out.println("  \t\t\t----------   Selection Sort   ----------\t\t\t\t\n");
		System.out.println("--------------------------------------------------------------------------------\n");
		System.out.print("----------   Enter number of strings: ");
		n = sc.nextInt();
		sc.nextLine();
		String[] names = new String[n];
		System.out.println("\n----------   Enter strings:");
		for (int i = 0; i < n; i++) {
        System.out.print("   String " + (i + 1) + ": ");
        names[i] = sc.nextLine();
		}
		for (int i = 0; i < n - 1; i++) {
        int minIndex = i;
        for (int j = i + 1; j < n; j++) {
            if (names[j].compareTo(names[minIndex]) < 0) {
                minIndex = j;
            }
        }
        if (minIndex != i) {
            String temp = names[i];
            names[i] = names[minIndex];
            names[minIndex] = temp;
			}
		}
		System.out.println("\t\t----------   The strings after sorting   ----------\n");
		System.out.print("----------   ");
		for (int i = 0; i < n; i++) {
        System.out.print(names[i] + "  ");
		}
		System.out.println("\n--------------------------------------------------------------------------------");
		System.out.println("--------------------------------------------------------------------------------\n");
		
	}
	public static void Lsearch() {
        int n;
		int flag=0;
        System.out.println("  \t\t\t----------   Linear Search   ----------\t\t\t\t\n");
        System.out.println("--------------------------------------------------------------------------------\n");

        System.out.println("----------   Enter number of strings: ");
		System.out.print("----------   ");
        n = sc.nextInt();
        sc.nextLine();
        String[] str = new String[n];
        System.out.println("\n----------   Enter strings:");
        for (int i = 0; i < str.length; i++) {
            System.out.print("----------   String " + (i + 1) + ": ");
            str[i] = sc.nextLine();
        }
        System.out.println("--------------------------------------------------------------------------------\n");
        System.out.println("----------   Enter a string to search: ");
        String key = sc.nextLine();
        System.out.println("--------------------------------------------------------------------------------\n");
        for (int i = 0; i < str.length; i++) {
            if (str[i].equals(key)) {
                flag=1;
                System.out.println("\n----------   String " + key + " is found at position " + (i + 1) + ".");
                break;
            }
        }
        if (flag==0) {
            System.out.println("----------   String not found.");
        }
        System.out.println("\n--------------------------------------------------------------------------------\n");
        System.out.println("--------------------------------------------------------------------------------\n");
	}
	public static void Bsearch() {
        System.out.println("  \t\t\t----------   Binary Search   ----------\t\t\t\t");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("----------   Enter number of strings: ");
	System.out.print("----------   ");
        int n = sc.nextInt();
        sc.nextLine();
        String[] strings = new String[n];
        System.out.println("/n----------   Enter the strings in sorted order:/n");
        for (int i = 0; i < n; i++) {
            System.out.print("----------   String " + (i + 1) + ": ");
            strings[i] = sc.nextLine();
        }
        System.out.print("----------   Enter the string to search: ");
        String key = sc.nextLine();
        int result = binary(strings, n, key);
        if (result != -1) {
            System.out.println("\n----------   String " + key + " is found.");
        } else {
            System.out.println("\n----------   String " + key + " not found.");
        }
        System.out.println("\n--------------------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------------------\n");
    }

    public static int binary(String[] strings, int n, String key) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = key.compareTo(strings[mid]);
            if (cmp == 0) {
                return mid;
            } else if (cmp < 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}