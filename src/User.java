public class User
{
	String UserName=null;//�û�����
	String[] NameOfBorrowedBook=new String[100];//���û��ѽ�ͼ������
	int NumberOfBorrowedBook=0;//���û����ĵ�ͼ������
	static int TotalOfUser=0;//�����û�������
	public static void BorrowBook(String BookName,Book[] AllBook,String UserName,User[] AllUser)
	{
		if(Book.TotalOfBook==0)//ͼ���ͼ��Ϊ��
		{
			System.out.println("δ�ҵ�����Ҫ���ͼ��");
			return;
		}
		else//ͼ���ͼ�鲻Ϊ��
		{
			for(int i=0;i<Book.TotalOfBook;i++)//����ͼ����������ͼ��
			{
				if(AllBook[i].BookName.equals(BookName))//�ҵ���ƥ���ͼ��
				{
					if(AllBook[i].AvailableOfBook>0)//���ڼܿɽ��ͼ��
					{
						if(User.TotalOfUser==0)//�û�Ϊ��
						{
							System.out.println("���û�������");
							return;
						}
						else//�û���Ϊ��
						{
							for(int j=0;j<User.TotalOfUser;j++)//���������û�
							{
								if(AllUser[j].UserName.equals(UserName))//�ҵ���ƥ����û�
								{
									AllUser[j].NameOfBorrowedBook[AllUser[j].NumberOfBorrowedBook]=new String();
									AllUser[j].NameOfBorrowedBook[AllUser[j].NumberOfBorrowedBook]=BookName;
									AllUser[j].NumberOfBorrowedBook++;
									AllBook[i].NumberOfReturnDay[AllBook[i].NumberOfBook-AllBook[i].AvailableOfBook]=30;
									AllBook[i].AvailableOfBook--;
									System.out.println("����ɹ�");
									return;
								}
							}
							System.out.println("���û�������");//δ�ҵ���ƥ����û�
							return;
						}
					}
					else//���ڼܿɽ�ͼ��
					{
						System.out.println("�������Ѿ�ȫ����裬δ���ڼܿɽ�Ĵ�����");
						return;
					}
				}
			}
			System.out.println("δ�ҵ�����Ҫ���ͼ��");//����ͼ����������ͼ���δ�ҵ���ƥ���ͼ��
			return;
		}
	}
	public static void ReturnBook(String BookName,Book[] AllBook,String UserName,User[] AllUser)
	{
		for(int i=0;i<Book.TotalOfBook;i++)//��������ͼ��
		{
			if(AllBook[i].BookName.equals(BookName))//�ҵ���ƥ���ͼ��
			{
				if(AllBook[i].AvailableOfBook<AllBook[i].NumberOfBook)//����������貿��
				{
					for(int j=0;j<User.TotalOfUser;j++)//���������û�
					{
						if(AllUser[j].UserName.equals(UserName))//�ҵ���ƥ����û�
						{
							for(int k=0;k<AllUser[j].NumberOfBorrowedBook;k++)//�ڴ��û������н��ĵ���������
							{
								if(AllUser[j].NameOfBorrowedBook[k].equals(BookName))//�ڴ��û������н��ĵ�������������Ҫ������
								{
									for(int l=k;l<AllUser[j].NumberOfBorrowedBook-1;l++)//�����û�����������ⱾҪ��������������������ǰ����ǰһ�����Ϣ
									{
										AllUser[j].NameOfBorrowedBook[l]=AllUser[j].NameOfBorrowedBook[l+1];
									}
									AllUser[j].NumberOfBorrowedBook--;
									AllBook[i].AvailableOfBook++;
									System.out.println("����ɹ�");
									return;
								}
							}
							System.out.println("���û�δ�������");//�ڴ��û������н��ĵ�����δ�ҵ�Ҫ������
							return;
						}
					}
					System.out.println("���û�������");//δ�ҵ���ƥ����û�
					return;
				}
				else//������û����貿��
				{
					System.out.println("�������Ѿ�ȫ���黹��δ�����Ĵ�����");
					return;
				}
			}
		}
		System.out.println("δ�ҵ�����Ҫ����ͼ��");//δ�ҵ���ƥ���ͼ��
		return;
	}
	public static void InquireBook(String BookName,Book[] AllBook)
	{
		if(Book.TotalOfBook==0)
		{
			System.out.println("δ�ҵ�����Ҫ��ѯ��ͼ��");
			return;
		}
		else
		{
			for(int i=0;i<Book.TotalOfBook;i++)
			{
				if(AllBook[i].BookName.equals(BookName))
				{
					System.out.println("��ѯ���:");
					System.out.println("ͼ������:"+AllBook[i].BookName);
					System.out.println("����ͼ�鹲��:"+AllBook[i].NumberOfBook+"��");
					System.out.println("�ѽ��:"+(AllBook[i].NumberOfBook-AllBook[i].AvailableOfBook)+"��");
					if(AllBook[i].NumberOfBook-AllBook[i].AvailableOfBook!=0)//����н����ͼ��
					{
						System.out.print("ʣ�໹��ʱ��ֱ�Ϊ:");
						for(int j=0;j<AllBook[i].NumberOfBook-AllBook[i].AvailableOfBook;j++)
						{
							System.out.print(AllBook[i].NumberOfReturnDay[j]+"��\t");
						}
						System.out.println("");
					}
					System.out.println("�ڼܿɽ�:"+AllBook[i].AvailableOfBook+"��");
					return;
				}
			}
			System.out.println("δ�ҵ�����Ҫ��ѯ��ͼ��");
			return;
		}
	}
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
	}
}
