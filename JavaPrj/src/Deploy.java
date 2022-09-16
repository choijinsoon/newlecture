import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

/*
 * 
 * class ShuffleSeats{
 * 		public ShuffleSeats(String initFile){...}
 * 		public void shuffle(){}
 * 		public List<Seat> getSeats(){}
 * 		
 * }
 * 
 * class Seat{
 * 		private String userName;
 * 		private String group;
 * 		private String idx;
 * }
 * 
 * class Program{
 * 		main(){
 * 			ShuffleSeats sf = new ShuffleSeats("res/...");
 * 			sf.shuffle();
 * 			List<Seat> list = sf.getSeats();
 *     }
 * }
 * 
 */

public class Deploy {
	public static void main(String[] args) throws IOException {
		File f = new File("res/randomseat2.txt");
		FileReader fr = new FileReader(f);
		Random ran = new Random();
		BufferedReader br = new BufferedReader(fr);
		//	OutputStream
		int xaxis = 0, yaxis = 0;
		String pop;
		pop = br.readLine();
		int total = (int) pop.charAt(0) - 48;
		xaxis = (int) pop.charAt(1) - 48;
		yaxis = (int) pop.charAt(2) - 48;
		String jari[][] = new String[xaxis][yaxis];
		int sex[][] = new int[xaxis][yaxis];
		int sex2[][] = new int[xaxis][yaxis];
		int sex3[][] = new int[xaxis][yaxis];
		int onoff[][] = new int[xaxis][yaxis];
		int ttotal[] = new int[xaxis];
		int dtotal[] = new int[xaxis];
		String namee[] = { "������", "��ȣ��", "���缮", "������", "������", "�ý±�", "������", "�����", "�̼���", "�ڵ���", "�ֿ���", "���ָ�", "������",
				"���̺�", "������", "����", "������", "�Ⱑ��", "������", "������" };

		// �ڷ� �Է�
		while (true) {
			pop = br.readLine();
			if (pop == null)
				break;
			else if ((int) pop.charAt(0) == (int) '#') {
				for (int i = 0; i < xaxis; i++) {
					pop = br.readLine();
					String jari2[] = pop.split(" ");
					for (int j = 0; j < yaxis; j++) {
						jari[i][j] = jari2[j];
					}
				}
			} else if ((int) pop.charAt(0) == (int) '&') {
				for (int i = 0; i < xaxis; i++) {
					pop = br.readLine();
					String jari2[] = pop.split(" ");
					for (int j = 0; j < yaxis; j++) {
						int an = Integer.parseInt(jari2[j]);
						sex[i][j] = an;
						sex3[i][j] = an;
					}
				}
			}
		}

		// ���� �� ���
		System.out.println("     <������ �ڸ���ġ>");
		int ttl3;
		for (int i = 0; i < xaxis; i++) {
			System.out.print(i + 1 + "�� : ");
			if (i < 3) {
				for (int j = 0; j < yaxis; j++) {
					ttl3 = (int) jari[i][j].charAt(0);
					System.out.print(namee[ttl3 - 97] + " ");
				}
			} else if (i >= 3) {
				for (int j = 0; j < yaxis; j++) {
					ttl3 = (int) jari[i][yaxis - 1 - j].charAt(0);
					System.out.print(namee[ttl3 - 97] + " ");
				}
			}
			System.out.println("");
		}

		// �ʱ� �迭 ���� - ���� ����
		String jari3[][] = new String[xaxis][yaxis];
		int xx = 0, yy = 0;

		for (int i = 0; i < xaxis; i++) {
			int ttl = ran.nextInt(xaxis);
			while (jari3[ttl][1] != null) {
				ttl = ran.nextInt(xaxis);
			}
			jari3[ttl][1] = jari[i][1];
			sex[ttl][1] = sex3[i][1];
			onoff[i][1] = 1;
		}
		/*jari3[3][0] = jari[3][0];
		sex[3][0] = sex3[3][0];
		onoff[3][0] = 1;*/
		
		int swi = 0;
		String jari4[][] = new String[xaxis][yaxis];

		// ���� ���� �� �����迭
		//jari3[3][0] = "q";
		for (int i = 0; i < xaxis; i++) {
			for (int j = 0; j < yaxis; j++) {
				jari4[i][j] = jari3[i][j];
				sex2[i][j] = sex[i][j];
			}
		}
		int pnum = 0, mnum = 0, swii = 0;
		do {
			do {
				pnum = 0;
				swii = 0;
				mmx: for (int i = 0; i < xaxis; i++) {
					for (int j = 0; j < yaxis; j++) {
						if (onoff[i][j] == 0) {
							do {
								swi = 0;
								do {
									xx = ran.nextInt(xaxis);
									yy = ran.nextInt(yaxis);
								} while (jari3[xx][yy] != null);
								for (int k = 0; k < yaxis; k++) {
									for (int m = 0; m < yaxis; m++) {
										if (jari[i][k] == jari3[xx][m])
											swi = 1;
									}
								}
								pnum++;
								if (pnum >= 100) {
									for (int qq = 0; qq < xaxis; qq++) {
										for (int ww = 0; ww < yaxis; ww++) {
											jari3[qq][ww] = jari4[qq][ww];
										}
									}
									break mmx;
								}
							} while (swi == 1);
							jari3[xx][yy] = jari[i][j];
							sex2[xx][yy] = sex[i][j];
						}
					}
				}
			} while (pnum >= 100);
			/*if (pnum < 100) {
				for (int k = 0; k < xaxis; k++) {
					mnum = 0;
					for (int m = 0; m < yaxis; m++) {
						mnum += sex2[k][m];
					}
					if (mnum == 0) {
						for (int qq = 0; qq < xaxis; qq++) {
							for (int ww = 0; ww < yaxis; ww++) {
								jari3[qq][ww] = jari4[qq][ww];
								sex2[qq][ww] = sex[qq][ww];
							}
						}
						swii = 1;
					}
				}
			}*/
		} while (swii == 1);

		// ���� �� ���
		System.out.println("\nrule1.������ �̹� ���� 2ȸ�� ���� �����˴ϴ�");
		System.out.println("rule2.���� �������� ��ġ�� �ʰ� �����˴ϴ�.");
		System.out.println("/* rule3.�� ������ �Ѹ� �̻��� ���� ������ �����˴ϴ�. */\n");

		System.out.println("     <������ �ڸ���ġ>");
		int ttl2;
		for (int i = 0; i < xaxis; i++) {
			System.out.print(i + 1 + "�� : ");
			if (i < 3) {
				for (int j = 0; j < yaxis; j++) {
					ttl2 = (int) jari3[i][j].charAt(0);
					System.out.print(namee[ttl2 - 97] + " ");
				}
			} else if (i >= 3) {
				for (int j = 0; j < yaxis; j++) {
					ttl2 = (int) jari3[i][yaxis - 1 - j].charAt(0);
					System.out.print(namee[ttl2 - 97] + " ");
				}
			}
			System.out.println("");
		}
		br.close();

	}
}