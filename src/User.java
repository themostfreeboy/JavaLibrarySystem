public class User
{
	String UserName=null;//用户名称
	String[] NameOfBorrowedBook=new String[100];//此用户已借图书名称
	int NumberOfBorrowedBook=0;//此用户借阅的图书总数
	static int TotalOfUser=0;//所有用户的总数
	public static void BorrowBook(String BookName,Book[] AllBook,String UserName,User[] AllUser)
	{
		if(Book.TotalOfBook==0)//图书馆图书为空
		{
			System.out.println("未找到你所要借的图书");
			return;
		}
		else//图书馆图书不为空
		{
			for(int i=0;i<Book.TotalOfBook;i++)//搜索图书馆里的所有图书
			{
				if(AllBook[i].BookName.equals(BookName))//找到相匹配的图书
				{
					if(AllBook[i].AvailableOfBook>0)//有在架可借的图书
					{
						if(User.TotalOfUser==0)//用户为空
						{
							System.out.println("此用户不存在");
							return;
						}
						else//用户不为空
						{
							for(int j=0;j<User.TotalOfUser;j++)//搜索所有用户
							{
								if(AllUser[j].UserName.equals(UserName))//找到相匹配的用户
								{
									AllUser[j].NameOfBorrowedBook[AllUser[j].NumberOfBorrowedBook]=new String();
									AllUser[j].NameOfBorrowedBook[AllUser[j].NumberOfBorrowedBook]=BookName;
									AllUser[j].NumberOfBorrowedBook++;
									AllBook[i].NumberOfReturnDay[AllBook[i].NumberOfBook-AllBook[i].AvailableOfBook]=30;
									AllBook[i].AvailableOfBook--;
									System.out.println("借书成功");
									return;
								}
							}
							System.out.println("此用户不存在");//未找到相匹配的用户
							return;
						}
					}
					else//无在架可借图书
					{
						System.out.println("此种书已经全部外借，未有在架可借的此种书");
						return;
					}
				}
			}
			System.out.println("未找到你所要借的图书");//搜索图书馆里的所有图书后未找到相匹配的图书
			return;
		}
	}
	public static void ReturnBook(String BookName,Book[] AllBook,String UserName,User[] AllUser)
	{
		for(int i=0;i<Book.TotalOfBook;i++)//搜索所有图书
		{
			if(AllBook[i].BookName.equals(BookName))//找到相匹配的图书
			{
				if(AllBook[i].AvailableOfBook<AllBook[i].NumberOfBook)//此种书有外借部分
				{
					for(int j=0;j<User.TotalOfUser;j++)//搜索所有用户
					{
						if(AllUser[j].UserName.equals(UserName))//找到相匹配的用户
						{
							for(int k=0;k<AllUser[j].NumberOfBorrowedBook;k++)//在此用户的所有借阅的书中搜索
							{
								if(AllUser[j].NameOfBorrowedBook[k].equals(BookName))//在此用户中所有借阅的书中搜索到了要还的书
								{
									for(int l=k;l<AllUser[j].NumberOfBorrowedBook-1;l++)//将此用户所借的书中这本要还的书后的所有书依次向前覆盖前一项的信息
									{
										AllUser[j].NameOfBorrowedBook[l]=AllUser[j].NameOfBorrowedBook[l+1];
									}
									AllUser[j].NumberOfBorrowedBook--;
									AllBook[i].AvailableOfBook++;
									System.out.println("还书成功");
									return;
								}
							}
							System.out.println("此用户未借此种书");//在此用户中所有借阅的书中未找到要还的书
							return;
						}
					}
					System.out.println("此用户不存在");//未找到相匹配的用户
					return;
				}
				else//此种书没有外借部分
				{
					System.out.println("此种书已经全部归还，未有外借的此种书");
					return;
				}
			}
		}
		System.out.println("未找到你所要还的图书");//未找到相匹配的图书
		return;
	}
	public static void InquireBook(String BookName,Book[] AllBook)
	{
		if(Book.TotalOfBook==0)
		{
			System.out.println("未找到你所要查询的图书");
			return;
		}
		else
		{
			for(int i=0;i<Book.TotalOfBook;i++)
			{
				if(AllBook[i].BookName.equals(BookName))
				{
					System.out.println("查询结果:");
					System.out.println("图书名称:"+AllBook[i].BookName);
					System.out.println("此种图书共有:"+AllBook[i].NumberOfBook+"本");
					System.out.println("已借出:"+(AllBook[i].NumberOfBook-AllBook[i].AvailableOfBook)+"本");
					if(AllBook[i].NumberOfBook-AllBook[i].AvailableOfBook!=0)//如果有借出的图书
					{
						System.out.print("剩余还书时间分别为:");
						for(int j=0;j<AllBook[i].NumberOfBook-AllBook[i].AvailableOfBook;j++)
						{
							System.out.print(AllBook[i].NumberOfReturnDay[j]+"天\t");
						}
						System.out.println("");
					}
					System.out.println("在架可借:"+AllBook[i].AvailableOfBook+"本");
					return;
				}
			}
			System.out.println("未找到你所要查询的图书");
			return;
		}
	}
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
	}
}
