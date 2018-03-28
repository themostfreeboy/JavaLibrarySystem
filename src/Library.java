public class Library 
{
	public static void InsertBook(String BookName,Book[] AllBook)
	{
		if(Book.TotalOfBook==0)//图书馆图书为空
		{
			AllBook[Book.TotalOfBook]=new Book();
			AllBook[Book.TotalOfBook].BookName=BookName;//将此种书添加进图书馆
			AllBook[Book.TotalOfBook].NumberOfBook++;//该种书一共有的本数+1
			AllBook[Book.TotalOfBook].AvailableOfBook++;//该种书在架可借的本数+1
			Book.TotalOfBook++;//所有书的种类总数+1
			return;
		}
		else//图书馆图书不为空
		{
			for(int i=0;i<Book.TotalOfBook;i++)//搜索所有图书
			{
				if(AllBook[i].BookName.equals(BookName))//如果图书馆已经有该种书
				{
					AllBook[i].NumberOfBook++;//该种书一共有的本数+1
					AllBook[i].AvailableOfBook++;//该种书在架可借的本数+1
					System.out.println("添加图书成功");
					return;
				}
			}
            //如果图书馆没有该种书
			AllBook[Book.TotalOfBook]=new Book();
			AllBook[Book.TotalOfBook].BookName=BookName;//将此种书添加进图书馆
			AllBook[Book.TotalOfBook].NumberOfBook++;//该种书一共有的本数+1
			AllBook[Book.TotalOfBook].AvailableOfBook++;//该种书在架可借的本数+1
			Book.TotalOfBook++;//所有书的种类总数+1
			System.out.println("添加图书成功");
			return;
		}
	}
	public static void DeleteBook(String BookName,Book[] AllBook,User[] AllUser)
	{
		for(int i=0;i<Book.TotalOfBook;i++)//搜索所有图书
		{
			if(AllBook[i].BookName.equals(BookName))//如果在图书馆中搜索到了此种书
			{
				if(AllBook[i].NumberOfBook==AllBook[i].AvailableOfBook)//此种书都没有外借
				{
					for(int j=i;j<Book.TotalOfBook-1;j++)//将此种图书后面的图书信息依次覆盖前面一种的图书信息
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
					System.out.println("删除图书成功");
					return;
				}
				else//此种书有正在外借的部分
				{
					System.out.println("此种书有"+(AllBook[i].NumberOfBook-AllBook[i].AvailableOfBook)+"本正在外借中，是否仍继续删除？");
					System.out.println("1:是\n2:否");
					int Choice_1=MyInput.readInt();
					if(Choice_1==1)
					{
						System.out.println("是否删除此"+(AllBook[i].NumberOfBook-AllBook[i].AvailableOfBook)+"个用户对此种图书的借阅信息？");
						System.out.println("1:是\n2:否");
						int Choice_2=MyInput.readInt();
						if(Choice_2==1)
						{
							int TempNumberOfUser=0;//用于存储以下for循环中已找到的借阅此种书的用户数
							for(int l=0;l<User.TotalOfUser&&TempNumberOfUser<(AllBook[i].NumberOfBook-AllBook[i].AvailableOfBook);l++)//在所有用户中搜索借阅此种书的所有用户
							{
								for(int m=0;m<AllUser[l].NumberOfBorrowedBook;m++)//在某一用户中依次对所借的书进行搜索
								{
									if(AllUser[l].NameOfBorrowedBook[m].equals(AllBook[i].BookName))
									{
										for(int n=m;n<AllUser[l].NumberOfBorrowedBook-1;n++)//将此用户所借图书该种图书后的信息一次覆盖到前一个
										{
											AllUser[l].NameOfBorrowedBook[n]=AllUser[l].NameOfBorrowedBook[n+1];
										}
										AllUser[l].NumberOfBorrowedBook--;
										System.out.println("删除图书成功");
										break;
									}
								}
								TempNumberOfUser++;
							}
							return;
						}
						else if(Choice_2==2)
						{
							for(int j=i;j<Book.TotalOfBook-1;j++)//将此种图书后面的图书信息依次覆盖前面一种的图书信息
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
							System.out.println("删除图书成功");
							return;
						}
						else
						{
							System.out.println("你输入的数据有误");
							//System.exit(0);
							return;
						}
					}
					else if(Choice_1==2)
					{
						System.out.println("此种书未删除");
						return;
					}
					else
					{
						System.out.println("你输入的数据有误");
						//System.exit(0);
						return;
					}
				}
			}
		}
		System.out.println("图书馆中未搜索到此书，删除图书失败");//在图书馆中没有搜索到此种书
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
			System.out.println("添加用户成功");
			return;
		}
		else
		{
			for(int i=0;i<User.TotalOfUser;i++)//检查此用户是否存在
			{
				if(AllUser[i].UserName.equals(UserName))
				{
					System.out.println("此用户已存在");
					return;
				}
			}
			AllUser[User.TotalOfUser]=new User();
			AllUser[User.TotalOfUser].UserName=UserName;
			AllUser[User.TotalOfUser].NumberOfBorrowedBook=0;
			User.TotalOfUser++;
			System.out.println("添加用户成功");
			return;
		}
	}
	public static void DeleteUser(String UserName,User[] AllUser,Book[] AllBook)
	{
		for(int i=0;i<User.TotalOfUser;i++)//在所有用户中搜索
		{
			if(AllUser[i].UserName.equals(UserName))//如果有此用户
			{
				if(AllUser[i].NumberOfBorrowedBook==0)//如果此用户没有借阅图书
				{
					for(int j=i;j<User.TotalOfUser-1;j++)//将此用户后的用户信息依次覆盖到前一个用户
					{
						AllUser[j].UserName=AllUser[j+1].UserName;
						AllUser[j].NumberOfBorrowedBook=AllUser[j+1].NumberOfBorrowedBook;
						for(int k=0;k<AllUser[j].NumberOfBorrowedBook-1;k++)
						{
							AllUser[j].NameOfBorrowedBook[k]=AllUser[j+1].NameOfBorrowedBook[k];
						}
					}
					User.TotalOfUser--;
					System.out.println("用户删除成功");
					return;
				}
				else//如果此用户借阅了图书
				{
					System.out.println("此用户借阅了图书，是否仍继续删除");
					System.out.println("1:是\n2:否");
					int Choice_1=MyInput.readInt();
					if(Choice_1==1)
					{
						System.out.println("将如何处理此用户所借的图书");
						System.out.println("1:将此用户所借图书注销\n2:将此用户所借图书还给图书馆");
						int Choice_2=MyInput.readInt();
						if(Choice_2==1)
						{
							for(int j=0;j<AllUser[i].NumberOfBorrowedBook;j++)
							{
								for(int k=0;k<Book.TotalOfBook;k++)
								{
									if(AllUser[i].NameOfBorrowedBook[j].equals(AllBook[k].BookName))
									{
										AllBook[k].NumberOfBook--;//将此用户所借图书注销
									}
								}
							}
							for(int j=i;j<User.TotalOfUser-1;j++)//将此用户后的用户信息依次覆盖到前一个用户
							{
								AllUser[j].UserName=AllUser[j+1].UserName;
								AllUser[j].NumberOfBorrowedBook=AllUser[j+1].NumberOfBorrowedBook;
								for(int k=0;k<AllUser[j].NumberOfBorrowedBook-1;k++)
								{
									AllUser[j].NameOfBorrowedBook[k]=AllUser[j+1].NameOfBorrowedBook[k];
								}
							}
							User.TotalOfUser--;
							System.out.println("用户删除成功");
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
										AllBook[k].AvailableOfBook++;//将此用户所借图书还给图书馆
									}
								}
							}
							for(int j=i;j<User.TotalOfUser-1;j++)//将此用户后的用户信息依次覆盖到前一个用户
							{
								AllUser[j].UserName=AllUser[j+1].UserName;
								AllUser[j].NumberOfBorrowedBook=AllUser[j+1].NumberOfBorrowedBook;
								for(int k=0;k<AllUser[j].NumberOfBorrowedBook-1;k++)
								{
									AllUser[j].NameOfBorrowedBook[k]=AllUser[j+1].NameOfBorrowedBook[k];
								}
							}
							User.TotalOfUser--;
							System.out.println("用户删除成功");
							return;
						}
						else
						{
							System.out.println("你输入的数据有误");
							//System.exit(0);
							return;
						}
					}
					else if(Choice_1==2)
					{
						System.out.println("此用户未删除");
						return;
					}
					else
					{
						System.out.println("你输入的数据有误");
						//System.exit(0);
						return;
					}
				}
			}
		}
		System.out.println("未发现此用户");//没有此用户
		return;
	}
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
	}
}
