package euler.problem21bis30;

// Problem 24
public class LexigraphicPermutations
{
	int[] num = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };

	public static void main(String[] args)
	{
		new LexigraphicPermutations().calc();

	}

	private void calc()
	{
		int counter = 0;
		for (int i0 = 0; i0 < num.length; i0++)
		{
			for (int i1 = 0; i1 < num.length; i1++)
			{
				if (i1 != i0)
				{
					for (int i2 = 0; i2 < num.length; i2++)
					{
						if (i2 != i0 && i2 != i1)
						{
							for (int i3 = 0; i3 < num.length; i3++)
							{
								if (i3 != i0 && i3 != i1 && i3 != i2)
								{
									for (int i4 = 0; i4 < num.length; i4++)
									{
										if (i4 != i0 && i4 != i1 && i4 != i2 && i4 != i3)
										{
											for (int i5 = 0; i5 < num.length; i5++)
											{
												if (i5 != i0 && i5 != i1 && i5 != i2
													&& i5 != i3 && i5 != i4)
												{
													for (int i6 = 0; i6 < num.length; i6++)
													{
														if (i6 != i0 && i6 != i1 && i6 != i2
															&& i6 != i3 && i6 != i4 && i6 != i5)
														{
															for (int i7 = 0; i7 < num.length; i7++)
															{
																if (i7 != i0 && i7 != i1
																	&& i7 != i2 && i7 != i3
																	&& i7 != i4 && i7 != i5
																	&& i7 != i6)
																{
																	for (int i8 = 0; i8 < num.length; i8++)
																	{
																		if (i8 != i0
																			&& i8 != i1
																			&& i8 != i2
																			&& i8 != i3
																			&& i8 != i4
																			&& i8 != i5
																			&& i8 != i6
																			&& i8 != i7)
																		{
																			for (int i9 = 0; i9 < num.length; i9++)
																			{
																				if (i9 != i0
																					&& i9 != i1
																					&& i9 != i2
																					&& i9 != i3
																					&& i9 != i4
																					&& i9 != i5
																					&& i9 != i6
																					&& i9 != i7
																					&& i9 != i8)
																				{
																					counter++;
																					String number =
																						""
																							+ num[i1]
																							+ num[i2]
																							+ num[i3]
																							+ num[i4]
																							+ num[i5]
																							+ num[i6]
																							+ num[i7]
																							+ num[i8]
																							+ num[i9];
																					if (number.equals("2783915460"))
																					{
																						System.out.println(counter
																							+ ":"
																							+ number);
																						return;
																					}
																				}
																			}

																		}
																	}

																}
															}

														}
													}

												}
											}

										}
									}

								}
							}
						}
					}
				}
			}
		}
	}
}
