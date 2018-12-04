import mpi.*;

public class Program {
  public static void main(String[] args) throws Exception {
    MPI.Init(args);
    int id = MPI.COMM_WORLD.Rank();
    int size = MPI.COMM_WORLD.Size();
    int[] sum = new int[1];
    int start = 10000 * id / size + 1;
    int end = 10000 * (id + 1) / size;
    for (int i = start; i <= end; i++) {
      sum[0] += i;
    }
    System.out.println("Process " + id + " of " + size + ". Partial sum is: " + sum[0]);
    if (id == 0) {
      int[] accum = new int[1];
      for (int j = 1; j < size; j = j + 1) {
        MPI.COMM_WORLD.Recv(accum, 0, 1, MPI.INT, j, 1);
        sum[0] += accum[0];
        System.out.println("The sum yet is: " + sum[0]);
      }
    }
    else {
      MPI.COMM_WORLD.Send(sum, 0, 1, MPI.INT, 0, 1);
    }
    if (id == 0) {
      System.out.println("The sum from 1 to 10000 is: " + sum[0]);
    }
    MPI.Finalize();
  }
}
