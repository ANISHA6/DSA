public class solution {

	public static void towerOfHanoi(int disks, char source, char auxiliary, char destination) {
		// Write your code here
        if(disks==0){
            return;
        }
        if(disks==1){
            System.out.println(source +" "+ destination);
            return;
        }
        towerOfHanoi(disks-1,source,destination,auxiliary);//Moving n-1 disk from source to helper using d
        System.out.println(source+" "+ destination);//for 1 disk just print no need to use recursion
        towerOfHanoi(disks-1,auxiliary,source,destination);// Moving n-1 disk from h to d using s

	}
}
