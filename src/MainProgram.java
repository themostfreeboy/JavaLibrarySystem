public class MainProgram 
{
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Book[] AllBook=new Book[100];
		User[] AllUser=new User[100];
		System.out.println("��Ϊ������(ѧ��:2012211706)���ͼ���ͼ�����ϵͳ");
		System.out.println("��ϵ���䣺361425474@qq.com");
		while(true)
		{
			System.out.println("����������Ҫ�����µı��:");
			System.out.println("1:ͼ��ݹ���Ա�������");
			System.out.println("2:�û�ͼ��������");
			int Choice_1=MyInput.readInt();
			if(Choice_1==1)
			{
				System.out.println("����������Ҫ�����µı��:");
				System.out.println("1:���ͼ��");
				System.out.println("2:ɾ��ͼ��");
				System.out.println("3:����û�");
				System.out.println("4:ɾ���û�");
				int Choice_2=MyInput.readInt();
				if(Choice_2==1)
				{
					System.out.println("��������Ҫ��ӵ�ͼ������");
					String BookName=MyInput.readString();
					Library.InsertBook(BookName,AllBook);
				}
				else if(Choice_2==2)
				{
					System.out.println("��������Ҫɾ����ͼ������");
					String BookName=MyInput.readString();
					Library.DeleteBook(BookName,AllBook,AllUser);
				}
				else if(Choice_2==3)
				{
					System.out.println("��������Ҫ��ӵ��û�����");
					String UserName=MyInput.readString();
					Library.InsertUser(UserName,AllUser);
				}
				else if(Choice_2==4)
				{
					System.out.println("��������Ҫɾ�����û�����");
					String UserName=MyInput.readString();
					Library.DeleteUser(UserName,AllUser,AllBook);
				}
				else
				{
					System.out.println("���������������");
					//System.exit(0);
				}
			}
			else if(Choice_1==2)
			{
				System.out.println("����������Ҫ�����µı��:");
				System.out.println("1:����");
				System.out.println("2:����");
				System.out.println("3:��ѯͼ��״̬");
				int Choice_2;
				Choice_2=MyInput.readInt();
				if(Choice_2==1)
				{
					System.out.println("��������Ҫ���ͼ������");
					String BookName=MyInput.readString();
					System.out.println("�������û�����");
					String UserName=MyInput.readString();
					User.BorrowBook(BookName,AllBook,UserName,AllUser);
				}
				else if(Choice_2==2)
				{
					System.out.println("��������Ҫ����ͼ������");
					String BookName=MyInput.readString();
					System.out.println("�������û�����");
					String UserName=MyInput.readString();
					User.ReturnBook(BookName,AllBook,UserName,AllUser);
				}
				else if(Choice_2==3)
				{
					System.out.println("��������Ҫ��ѯ��ͼ������");
					String BookName=MyInput.readString();
					User.InquireBook(BookName,AllBook);
				}
				else
				{
					System.out.println("���������������");
					//System.exit(0);
				}
			}
			else
			{
				System.out.println("���������������");
				//System.exit(0);
			}
		}
	}
}
