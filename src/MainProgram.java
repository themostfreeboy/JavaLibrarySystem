public class MainProgram 
{
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Book[] AllBook=new Book[100];
		User[] AllUser=new User[100];
		System.out.println("此为贾翔龙(学号:2012211706)编的图书馆图书管理系统");
		System.out.println("联系邮箱：361425474@qq.com");
		while(true)
		{
			System.out.println("请输入你想要做的事的编号:");
			System.out.println("1:图书馆管理员管理界面");
			System.out.println("2:用户图书管理界面");
			int Choice_1=MyInput.readInt();
			if(Choice_1==1)
			{
				System.out.println("请输入你想要做的事的编号:");
				System.out.println("1:添加图书");
				System.out.println("2:删除图书");
				System.out.println("3:添加用户");
				System.out.println("4:删除用户");
				int Choice_2=MyInput.readInt();
				if(Choice_2==1)
				{
					System.out.println("请输入需要添加的图书名称");
					String BookName=MyInput.readString();
					Library.InsertBook(BookName,AllBook);
				}
				else if(Choice_2==2)
				{
					System.out.println("请输入需要删除的图书名称");
					String BookName=MyInput.readString();
					Library.DeleteBook(BookName,AllBook,AllUser);
				}
				else if(Choice_2==3)
				{
					System.out.println("请输入需要添加的用户名称");
					String UserName=MyInput.readString();
					Library.InsertUser(UserName,AllUser);
				}
				else if(Choice_2==4)
				{
					System.out.println("请输入需要删除的用户名称");
					String UserName=MyInput.readString();
					Library.DeleteUser(UserName,AllUser,AllBook);
				}
				else
				{
					System.out.println("你输入的数据有误");
					//System.exit(0);
				}
			}
			else if(Choice_1==2)
			{
				System.out.println("请输入你想要做的事的编号:");
				System.out.println("1:借书");
				System.out.println("2:还书");
				System.out.println("3:查询图书状态");
				int Choice_2;
				Choice_2=MyInput.readInt();
				if(Choice_2==1)
				{
					System.out.println("请输入需要借的图书名称");
					String BookName=MyInput.readString();
					System.out.println("请输入用户名称");
					String UserName=MyInput.readString();
					User.BorrowBook(BookName,AllBook,UserName,AllUser);
				}
				else if(Choice_2==2)
				{
					System.out.println("请输入需要还的图书名称");
					String BookName=MyInput.readString();
					System.out.println("请输入用户名称");
					String UserName=MyInput.readString();
					User.ReturnBook(BookName,AllBook,UserName,AllUser);
				}
				else if(Choice_2==3)
				{
					System.out.println("请输入需要查询的图书名称");
					String BookName=MyInput.readString();
					User.InquireBook(BookName,AllBook);
				}
				else
				{
					System.out.println("你输入的数据有误");
					//System.exit(0);
				}
			}
			else
			{
				System.out.println("你输入的数据有误");
				//System.exit(0);
			}
		}
	}
}
