public class Library 
{
	public static void InsertBook(String BookName,Book[] AllBook)
	{
		if(Book.TotalOfBook==0)//ͼ���ͼ��Ϊ��
		{
			AllBook[Book.TotalOfBook]=new Book();
			AllBook[Book.TotalOfBook].BookName=BookName;//����������ӽ�ͼ���
			AllBook[Book.TotalOfBook].NumberOfBook++;//������һ���еı���+1
			AllBook[Book.TotalOfBook].AvailableOfBook++;//�������ڼܿɽ�ı���+1
			Book.TotalOfBook++;//���������������+1
			return;
		}
		else//ͼ���ͼ�鲻Ϊ��
		{
			for(int i=0;i<Book.TotalOfBook;i++)//��������ͼ��
			{
				if(AllBook[i].BookName.equals(BookName))//���ͼ����Ѿ��и�����
				{
					AllBook[i].NumberOfBook++;//������һ���еı���+1
					AllBook[i].AvailableOfBook++;//�������ڼܿɽ�ı���+1
					System.out.println("���ͼ��ɹ�");
					return;
				}
			}
            //���ͼ���û�и�����
			AllBook[Book.TotalOfBook]=new Book();
			AllBook[Book.TotalOfBook].BookName=BookName;//����������ӽ�ͼ���
			AllBook[Book.TotalOfBook].NumberOfBook++;//������һ���еı���+1
			AllBook[Book.TotalOfBook].AvailableOfBook++;//�������ڼܿɽ�ı���+1
			Book.TotalOfBook++;//���������������+1
			System.out.println("���ͼ��ɹ�");
			return;
		}
	}
	public static void DeleteBook(String BookName,Book[] AllBook,User[] AllUser)
	{
		for(int i=0;i<Book.TotalOfBook;i++)//��������ͼ��
		{
			if(AllBook[i].BookName.equals(BookName))//�����ͼ������������˴�����
			{
				if(AllBook[i].NumberOfBook==AllBook[i].AvailableOfBook)//�����鶼û�����
				{
					for(int j=i;j<Book.TotalOfBook-1;j++)//������ͼ������ͼ����Ϣ���θ���ǰ��һ�ֵ�ͼ����Ϣ
					{
						AllBook[j].BookName=AllBook[j+1].BookName;
						AllBook[j].NumberOfBook=AllBook[j+1].NumberOfBook;
						AllBook[j].AvailableOfBook=AllBook[j+1].AvailableOfBook;
						for(int k=0;k<AllBook[j+1].NumberOfBook-AllBook[j+1].AvailableOfBook;k++)
						{
							AllBook[j].NumberOfReturnDay[k]=AllBook[j+1].NumberOfReturnDay[k];
						}
					}
					Book.TotalOfBook--;
					System.out.println("ɾ��ͼ��ɹ�");
					return;
				}
				else//���������������Ĳ���
				{
					System.out.println("��������"+(AllBook[i].NumberOfBook-AllBook[i].AvailableOfBook)+"����������У��Ƿ��Լ���ɾ����");
					System.out.println("1:��\n2:��");
					int Choice_1=MyInput.readInt();
					if(Choice_1==1)
					{
						System.out.println("�Ƿ�ɾ����"+(AllBook[i].NumberOfBook-AllBook[i].AvailableOfBook)+"���û��Դ���ͼ��Ľ�����Ϣ��");
						System.out.println("1:��\n2:��");
						int Choice_2=MyInput.readInt();
						if(Choice_2==1)
						{
							int TempNumberOfUser=0;//���ڴ洢����forѭ�������ҵ��Ľ��Ĵ�������û���
							for(int l=0;l<User.TotalOfUser&&TempNumberOfUser<(AllBook[i].NumberOfBook-AllBook[i].AvailableOfBook);l++)//�������û����������Ĵ�����������û�
							{
								for(int m=0;m<AllUser[l].NumberOfBorrowedBook;m++)//��ĳһ�û������ζ���������������
								{
									if(AllUser[l].NameOfBorrowedBook[m].equals(AllBook[i].BookName))
									{
										for(int n=m;n<AllUser[l].NumberOfBorrowedBook-1;n++)//�����û�����ͼ�����ͼ������Ϣһ�θ��ǵ�ǰһ��
										{
											AllUser[l].NameOfBorrowedBook[n]=AllUser[l].NameOfBorrowedBook[n+1];
										}
										AllUser[l].NumberOfBorrowedBook--;
										System.out.println("ɾ��ͼ��ɹ�");
										break;
									}
								}
								TempNumberOfUser++;
							}
							return;
						}
						else if(Choice_2==2)
						{
							for(int j=i;j<Book.TotalOfBook-1;j++)//������ͼ������ͼ����Ϣ���θ���ǰ��һ�ֵ�ͼ����Ϣ
							{
								AllBook[j].BookName=AllBook[j+1].BookName;
								AllBook[j].NumberOfBook=AllBook[j+1].NumberOfBook;
								AllBook[j].AvailableOfBook=AllBook[j+1].AvailableOfBook;
								for(int k=0;k<AllBook[j+1].NumberOfBook-AllBook[j+1].AvailableOfBook;k++)
								{
									AllBook[j].NumberOfReturnDay[k]=AllBook[j+1].NumberOfReturnDay[k];
								}
							}
							Book.TotalOfBook--;
							System.out.println("ɾ��ͼ��ɹ�");
							return;
						}
						else
						{
							System.out.println("���������������");
							//System.exit(0);
							return;
						}
					}
					else if(Choice_1==2)
					{
						System.out.println("������δɾ��");
						return;
					}
					else
					{
						System.out.println("���������������");
						//System.exit(0);
						return;
					}
				}
			}
		}
		System.out.println("ͼ�����δ���������飬ɾ��ͼ��ʧ��");//��ͼ�����û��������������
		return;
	}
	public static void InsertUser(String UserName,User[] AllUser)
	{
		if(User.TotalOfUser==0)
		{
			AllUser[User.TotalOfUser]=new User();
			AllUser[User.TotalOfUser].UserName=UserName;
			AllUser[User.TotalOfUser].NumberOfBorrowedBook=0;
			User.TotalOfUser++;
			System.out.println("����û��ɹ�");
			return;
		}
		else
		{
			for(int i=0;i<User.TotalOfUser;i++)//�����û��Ƿ����
			{
				if(AllUser[i].UserName.equals(UserName))
				{
					System.out.println("���û��Ѵ���");
					return;
				}
			}
			AllUser[User.TotalOfUser]=new User();
			AllUser[User.TotalOfUser].UserName=UserName;
			AllUser[User.TotalOfUser].NumberOfBorrowedBook=0;
			User.TotalOfUser++;
			System.out.println("����û��ɹ�");
			return;
		}
	}
	public static void DeleteUser(String UserName,User[] AllUser,Book[] AllBook)
	{
		for(int i=0;i<User.TotalOfUser;i++)//�������û�������
		{
			if(AllUser[i].UserName.equals(UserName))//����д��û�
			{
				if(AllUser[i].NumberOfBorrowedBook==0)//������û�û�н���ͼ��
				{
					for(int j=i;j<User.TotalOfUser-1;j++)//�����û�����û���Ϣ���θ��ǵ�ǰһ���û�
					{
						AllUser[j].UserName=AllUser[j+1].UserName;
						AllUser[j].NumberOfBorrowedBook=AllUser[j+1].NumberOfBorrowedBook;
						for(int k=0;k<AllUser[j].NumberOfBorrowedBook-1;k++)
						{
							AllUser[j].NameOfBorrowedBook[k]=AllUser[j+1].NameOfBorrowedBook[k];
						}
					}
					User.TotalOfUser--;
					System.out.println("�û�ɾ���ɹ�");
					return;
				}
				else//������û�������ͼ��
				{
					System.out.println("���û�������ͼ�飬�Ƿ��Լ���ɾ��");
					System.out.println("1:��\n2:��");
					int Choice_1=MyInput.readInt();
					if(Choice_1==1)
					{
						System.out.println("����δ�����û������ͼ��");
						System.out.println("1:�����û�����ͼ��ע��\n2:�����û�����ͼ�黹��ͼ���");
						int Choice_2=MyInput.readInt();
						if(Choice_2==1)
						{
							for(int j=0;j<AllUser[i].NumberOfBorrowedBook;j++)
							{
								for(int k=0;k<Book.TotalOfBook;k++)
								{
									if(AllUser[i].NameOfBorrowedBook[j].equals(AllBook[k].BookName))
									{
										AllBook[k].NumberOfBook--;//�����û�����ͼ��ע��
									}
								}
							}
							for(int j=i;j<User.TotalOfUser-1;j++)//�����û�����û���Ϣ���θ��ǵ�ǰһ���û�
							{
								AllUser[j].UserName=AllUser[j+1].UserName;
								AllUser[j].NumberOfBorrowedBook=AllUser[j+1].NumberOfBorrowedBook;
								for(int k=0;k<AllUser[j].NumberOfBorrowedBook-1;k++)
								{
									AllUser[j].NameOfBorrowedBook[k]=AllUser[j+1].NameOfBorrowedBook[k];
								}
							}
							User.TotalOfUser--;
							System.out.println("�û�ɾ���ɹ�");
							return;
						}
						else if(Choice_2==2)
						{
							for(int j=0;j<AllUser[i].NumberOfBorrowedBook;j++)
							{
								for(int k=0;k<Book.TotalOfBook;k++)
								{
									if(AllUser[i].NameOfBorrowedBook[j].equals(AllBook[k].BookName))
									{
										AllBook[k].AvailableOfBook++;//�����û�����ͼ�黹��ͼ���
									}
								}
							}
							for(int j=i;j<User.TotalOfUser-1;j++)//�����û�����û���Ϣ���θ��ǵ�ǰһ���û�
							{
								AllUser[j].UserName=AllUser[j+1].UserName;
								AllUser[j].NumberOfBorrowedBook=AllUser[j+1].NumberOfBorrowedBook;
								for(int k=0;k<AllUser[j].NumberOfBorrowedBook-1;k++)
								{
									AllUser[j].NameOfBorrowedBook[k]=AllUser[j+1].NameOfBorrowedBook[k];
								}
							}
							User.TotalOfUser--;
							System.out.println("�û�ɾ���ɹ�");
							return;
						}
						else
						{
							System.out.println("���������������");
							//System.exit(0);
							return;
						}
					}
					else if(Choice_1==2)
					{
						System.out.println("���û�δɾ��");
						return;
					}
					else
					{
						System.out.println("���������������");
						//System.exit(0);
						return;
					}
				}
			}
		}
		System.out.println("δ���ִ��û�");//û�д��û�
		return;
	}
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
	}
}
