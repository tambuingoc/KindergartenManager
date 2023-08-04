USE [Kindergarten]
GO
/****** Object:  Table [dbo].[Classrooms]    Script Date: 04/08/2023 21:09:45 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Classrooms](
	[class_id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](50) NOT NULL,
	[quality] [int] NOT NULL,
	[room] [nchar](10) NOT NULL,
	[teacherName] [nvarchar](100) NOT NULL,
	[year] [nchar](10) NOT NULL,
 CONSTRAINT [PK__Classroo__FDF47986592F35A0] PRIMARY KEY CLUSTERED 
(
	[class_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Parent]    Script Date: 04/08/2023 21:09:45 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Parent](
	[id] [int] NOT NULL,
	[userId] [nvarchar](50) NOT NULL,
 CONSTRAINT [Parent_pkey] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Schedules]    Script Date: 04/08/2023 21:09:45 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Schedules](
	[schedule_id] [int] IDENTITY(1,1) NOT NULL,
	[time] [date] NOT NULL,
	[class_id] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[schedule_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ScheduleSubject]    Script Date: 04/08/2023 21:09:45 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ScheduleSubject](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[scheduleId] [int] NULL,
	[subjectId] [int] NULL,
 CONSTRAINT [ScheduleSubject_pkey] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SchoolYear]    Script Date: 04/08/2023 21:09:45 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SchoolYear](
	[year_id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](50) NOT NULL,
	[year] [nvarchar](50) NOT NULL,
	[startDate] [date] NOT NULL,
	[endDate] [date] NOT NULL,
 CONSTRAINT [PK__SchoolYe__B2A06B62DC5BA787] PRIMARY KEY CLUSTERED 
(
	[year_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Students]    Script Date: 04/08/2023 21:09:45 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Students](
	[student_id] [int] IDENTITY(1,1) NOT NULL,
	[studentNum] [int] NOT NULL,
	[yearSt] [nchar](10) NOT NULL,
	[classNameSt] [nvarchar](50) NOT NULL,
	[nameSt] [nvarchar](50) NOT NULL,
	[genderSt] [nchar](10) NOT NULL,
	[addressSt] [nvarchar](50) NOT NULL,
	[birthSt] [date] NOT NULL,
	[parentNameSt] [nvarchar](50) NOT NULL,
	[phoneSt] [nchar](10) NOT NULL,
	[statusSt] [nvarchar](50) NOT NULL,
	[imageSt] [nvarchar](100) NOT NULL,
 CONSTRAINT [PK__Studenst__2A33069A98FF57B9] PRIMARY KEY CLUSTERED 
(
	[student_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Subject]    Script Date: 04/08/2023 21:09:45 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Subject](
	[subject_id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](50) NOT NULL,
 CONSTRAINT [Subject_pkey] PRIMARY KEY CLUSTERED 
(
	[subject_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Teachers]    Script Date: 04/08/2023 21:09:45 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Teachers](
	[teacher_id] [int] IDENTITY(1,1) NOT NULL,
	[teacherNum] [int] NOT NULL,
	[name] [nvarchar](50) NOT NULL,
	[gender] [nchar](10) NOT NULL,
	[address] [nvarchar](50) NOT NULL,
	[phone] [nchar](10) NOT NULL,
	[dob] [date] NOT NULL,
	[cardID] [nvarchar](50) NOT NULL,
	[degree] [nvarchar](50) NOT NULL,
	[className] [nvarchar](50) NOT NULL,
	[salary] [float] NOT NULL,
	[image] [nvarchar](100) NOT NULL,
 CONSTRAINT [PK__Teachers__03AE777E3B5316D2] PRIMARY KEY CLUSTERED 
(
	[teacher_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[User]    Script Date: 04/08/2023 21:09:45 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[User](
	[userId] [nvarchar](50) NOT NULL,
	[username] [nvarchar](50) NOT NULL,
	[password] [nvarchar](50) NOT NULL,
	[email] [nvarchar](50) NOT NULL,
 CONSTRAINT [User_pkey] PRIMARY KEY CLUSTERED 
(
	[userId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Users]    Script Date: 04/08/2023 21:09:45 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Users](
	[user_id] [int] IDENTITY(1,1) NOT NULL,
	[username] [nvarchar](50) NOT NULL,
	[password] [nvarchar](50) NOT NULL,
	[email] [nvarchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[user_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Classrooms] ON 

INSERT [dbo].[Classrooms] ([class_id], [name], [quality], [room], [teacherName], [year]) VALUES (1, N'Mầm 1', 30, N'102       ', N'Nguyễn Hoàng Anh', N'K1        ')
INSERT [dbo].[Classrooms] ([class_id], [name], [quality], [room], [teacherName], [year]) VALUES (3, N'Lá 1', 30, N'105       ', N'Lê Thị Ngọc Trang', N'K5        ')
INSERT [dbo].[Classrooms] ([class_id], [name], [quality], [room], [teacherName], [year]) VALUES (4, N'Lá 2', 30, N'106       ', N'Phạm Thu Hương', N'K5        ')
INSERT [dbo].[Classrooms] ([class_id], [name], [quality], [room], [teacherName], [year]) VALUES (5, N'Mầm 2', 30, N'103       ', N'Nguyễn Hoàng Anh', N'K6        ')
INSERT [dbo].[Classrooms] ([class_id], [name], [quality], [room], [teacherName], [year]) VALUES (6, N'Chồi 1', 30, N'201       ', N'John', N'K7        ')
INSERT [dbo].[Classrooms] ([class_id], [name], [quality], [room], [teacherName], [year]) VALUES (7, N'Chồi 2', 30, N'202       ', N'Nguyễn Huy Hoàng', N'K7        ')
INSERT [dbo].[Classrooms] ([class_id], [name], [quality], [room], [teacherName], [year]) VALUES (8, N'Mầm 3', 30, N'104       ', N'Nguyễn Hoàng Anh', N'K1        ')
SET IDENTITY_INSERT [dbo].[Classrooms] OFF
GO
SET IDENTITY_INSERT [dbo].[Students] ON 

INSERT [dbo].[Students] ([student_id], [studentNum], [yearSt], [classNameSt], [nameSt], [genderSt], [addressSt], [birthSt], [parentNameSt], [phoneSt], [statusSt], [imageSt]) VALUES (5, 20220089, N'K2        ', N'Lá 1', N'Nguyễn Trần Khánh Vân', N'Nữ        ', N'Cầu Giấy', CAST(N'2019-07-25' AS Date), N'Nguyễn Thành Trung', N'0898357690', N'Học', N'E:\\rung-thong-dep-o-da-lat-checkin-.jpg')
SET IDENTITY_INSERT [dbo].[Students] OFF
GO
SET IDENTITY_INSERT [dbo].[Teachers] ON 

INSERT [dbo].[Teachers] ([teacher_id], [teacherNum], [name], [gender], [address], [phone], [dob], [cardID], [degree], [className], [salary], [image]) VALUES (1, 1, N'Nguyễn Hoàng Anh', N'Nữ        ', N'Hưng Yên', N'0976544329', CAST(N'1995-10-20' AS Date), N'033301003909', N'Cử nhân', N'Mầm 2', 10000000, N'E:\image\gv1.jpg')
INSERT [dbo].[Teachers] ([teacher_id], [teacherNum], [name], [gender], [address], [phone], [dob], [cardID], [degree], [className], [salary], [image]) VALUES (5, 2, N'Hoàng Khánh Vân', N'Nữ        ', N'Nam Định', N'0869344567', CAST(N'1989-04-30' AS Date), N'050032980769', N'Cao Đẳng', N'Mầm 1', 8000000, N'E:\image\gv2.jpg')
INSERT [dbo].[Teachers] ([teacher_id], [teacherNum], [name], [gender], [address], [phone], [dob], [cardID], [degree], [className], [salary], [image]) VALUES (7, 5, N'Lê Thị Ngọc Lan', N'Nữ        ', N'Hà Nội', N'033987699 ', CAST(N'1990-05-25' AS Date), N'0888567980123', N'Cử nhân', N'Lá 1', 10500000, N'E:\image\gv3.jpg')
INSERT [dbo].[Teachers] ([teacher_id], [teacherNum], [name], [gender], [address], [phone], [dob], [cardID], [degree], [className], [salary], [image]) VALUES (8, 6, N'Nguyễn Huy Hoàng', N'Nam       ', N'Hà Nội', N'0998789564', CAST(N'1996-10-10' AS Date), N'088598634219', N'Cao đẳng', N'Chồi 2', 9500000, N'E:\image\gv4.jpg')
INSERT [dbo].[Teachers] ([teacher_id], [teacherNum], [name], [gender], [address], [phone], [dob], [cardID], [degree], [className], [salary], [image]) VALUES (9, 4, N'Phạm Thu Hươnng', N'Nữ        ', N'Thái Bình', N'0935684219', CAST(N'1990-09-19' AS Date), N'0356789218', N'Thạc sĩ', N'Lá 2', 12000000, N'E:\image\gv5.jpg')
INSERT [dbo].[Teachers] ([teacher_id], [teacherNum], [name], [gender], [address], [phone], [dob], [cardID], [degree], [className], [salary], [image]) VALUES (10, 10, N'Anna', N'Nữ        ', N'UK', N'09        ', CAST(N'1993-06-20' AS Date), N'08', N'Thạc Sỹ', N'Lá 2', 15000000, N'E:\\rung-thong-dep-o-da-lat-checkin-.jpg')
SET IDENTITY_INSERT [dbo].[Teachers] OFF
GO
INSERT [dbo].[User] ([userId], [username], [password], [email]) VALUES (N'', N'', N'', N'')
GO
SET IDENTITY_INSERT [dbo].[Users] ON 

INSERT [dbo].[Users] ([user_id], [username], [password], [email]) VALUES (1, N'tam', N'1', N'tam@gmail.com')
INSERT [dbo].[Users] ([user_id], [username], [password], [email]) VALUES (2, N'ngoctam', N'123', N'ngoctam123@gmail.com')
INSERT [dbo].[Users] ([user_id], [username], [password], [email]) VALUES (3, N'tambn', N'a', N'tambn124@gmail.com')
INSERT [dbo].[Users] ([user_id], [username], [password], [email]) VALUES (4, N'bnt', N'a', N'ngoctam1010@gmail.com')
SET IDENTITY_INSERT [dbo].[Users] OFF
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [Parent_userId_key]    Script Date: 04/08/2023 21:09:45 ******/
ALTER TABLE [dbo].[Parent] ADD  CONSTRAINT [Parent_userId_key] UNIQUE NONCLUSTERED 
(
	[userId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
ALTER TABLE [dbo].[Parent]  WITH CHECK ADD  CONSTRAINT [Parent_userId_fkey] FOREIGN KEY([userId])
REFERENCES [dbo].[User] ([userId])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[Parent] CHECK CONSTRAINT [Parent_userId_fkey]
GO
