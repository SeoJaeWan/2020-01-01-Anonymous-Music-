package Single;

import Menu.Scene;

public class Single_Namebranch {
   //���� ���õǾ��� ��� ���� Ÿ���� ���� � ���� ȭ������ �����ų�� ���� 1���� �ٴҶ��� 2~���ķδ� �����Ʈ
   private String sing;

   public Single_Namebranch(Scene sc, String sing) {
      this.sing = sing;

      if (sing.equals("Nomusic")) {
         // ������ �ϴ� �ƹ� ���ǵ� ����??
         sc.getContentPane().removeAll();
         sc.add(new Single(sc,null)).requestFocus();
         sc.revalidate();
      } else if (sing.equals("Selectmusic")) {
         //
         System.out.println("�غ���");
      } else {
         // ���� ����
         /*
          * System.out.println("�غ���"); sc.getContentPane().removeAll(); sc.add(new
          * Single_Record(sc)); sc.revalidate();
          */

      }
   }

}