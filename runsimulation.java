package modelotermico;

/*Para escalonar o problema/simula��o deve-se aumentar o numero limite do indice das
 *matrizes geralmente atribuido corretamente nas declaracoes, por�m nos lacos de re-
 *peticao (ex.: for...) utiliza-se uma linha somente, de acordo com a especificacao
 *isso representa um dia somente.
 *Algumas variaveis tem indice 0 (e.g array[0]), siginifica 1 no Matlab. No momento
 *de aumentar dias, ou seja, dar escalabilidade a simulacao, deve-se elaborar uma so-
 *lucao adequada utilizando os recursos atuais.*/

public class runsimulation {
	
	

	double dados_MT[][] = new double[][]{{213183604, 83000, 75, 260410, 0, 89320, 79310, 83000, 65, 65, 80, 23.3, 25, 31.7, 2, 0, 5, 1, 151016.607, 87082.569, 1, 14384.1654, 0, 0, 79310, 1, 2, 1, 60}};
	double dados_CC[][] = new double[][]{{0.669137956, 0.602994621, 0.56418084, 0.532054078, 0.530600378, 0.527111499, 0.545282745, 0.558947521, 0.673499055, 0.742985899, 0.753016427, 0.795028347, 0.750690507, 0.757232156, 0.823375491, 0.841837476, 0.823811601, 0.808111644, 0.73775258, 0.642825992, 0.624364006, 0.727140573, 0.724233173, 0.778746911, 0.669137956}};
	double dados_temp[][] = new double[][]{{26.4333, 26.4333, 26.4333, 26.4333, 26.4333, 26.4333, 26.4333, 26.4333, 26.4333, 26.4333, 26.4333, 26.4333, 26.4333, 26.4333, 26.4333, 26.4333, 26.4333, 26.4333, 26.4333, 26.4333, 26.4333, 26.4333, 26.4333, 26.4333, 26.4333}};

	//int ntrafo;

	

	public runsimulation(int t){
		new output().setFile();
		
		int ntrafo, J, DTP,  K;
		
		double DT, THS = 0, TW = 0, TTO = 0, TTDO=0, TBO = 0, MPR, JLAST, TFAVE, TWO, JJJ, THSMAX, TTOMAX, TIMS = 0, TIMSH, ASUM = 0;
		
		double[][] dados_TIM = new double[1][25];
		
		int tam=1;
		double[] NM = new double[tam];
		double[] XKVA1 = new double[tam];
		double[] TKVA1 = new double[tam];
		double[] PW1 = new double[tam];
		double[] PE1 = new double[tam];
		double[] PS1 = new double[tam];
		double[] PC = new double[tam];
		double[] XKVA2 = new double[tam];
		double[] THKVA2 = new double[tam];
		double[] THEWA = new double[tam];
		double[] THEHSA = new double[tam];
		double[] THETOR = new double[tam];
		double[] THEBOR = new double[tam];
		double[] TAR = new double[tam];
		double[] MC = new double[tam];
		double[] PUELHS = new double[tam];
		double[] TAUW = new double[tam];
		double[] HHS = new double[tam];
		double[] WCC = new double[tam];
		double[] WTANK = new double[tam];
		double[] MF = new double[tam];
		double[] GFLUID = new double[tam];
		double[] MCORE = new double[tam];
		double[] TIMCOR = new double[tam];
		double[] PCOE = new double[tam];
		double[] LCAS = new double[tam];
		double[] MA = new double[tam];
		double[] MPR1 = new double[tam];

		
		double SL, PL = 0, SLAMB, TA = 0, TDAO, TKW, QWGEN, VIS, QWLOST, DTDO, QHSGEN, VISHS, QLHS, QS, QLOSTF, QC = 0, DTTB, FAA, FEQA;
		

		double TK = 0, CPW = 0, CPF = 0, RHOF = 0, C8 = 0, B8 = 0;

		double X8 = 0, YN8 = 0, Z8 = 0;

		double THEDOR = 0;

		double TWR, TWRT, THSR, TTOR, TBOR, TTDOR, TWOR, TDAOR, TFAVER, XK2, TK2, PW, PE, PS, PT;

	    double TKHS, PWHS, PEHS;

	    

	    double XMCP;

	    double WWIND, WCORE, CPST, WFL, SUMMCP, T, VISR, VIHSR, TMP, KK;  	   

	    double[] TIMSH_P = new double[25];
		double[] PL_P = new double[25];
		double[] TA_P = new double[25];
		double[] THS_P = new double[25];
		double[] TTO_P = new double[25];
		double[] TTDO_P = new double[25];
		double[] TBO_P = new double[25];
	    
	    
		double[] TIM = new double[25];

			

		double[][] AMB = new double[25][25];
		double[][] PUL = new double[25][25];
		double[][] JJ = new double[25][25];

		
		

		System.out.println("Hello");

		System.out.println(Math.exp(2.567));

		//dados_TIM[0][i] -> Dados_TIM = 0:1:24;
		
		for(int i=0;i<=24;i++){
			dados_TIM[0][i] = i;
		}
		for(int i=0;i<=24;i++){
			System.out.println("Dados TIM[" + i + "] = " + dados_TIM[0][i]);
		}


		


		




		for(int i=0;i<=27;i++){
			if(i == 0){
				NM[i] = dados_MT[i][0];
				System.out.println("NM"+ NM[i]);
				XKVA1[i] = dados_MT[i][1];
				System.out.println("XKVA1" + XKVA1[i]);		
				TKVA1[i] = dados_MT[i][2];
				System.out.println("TKVA1" + TKVA1[i]);
				PW1[i] = dados_MT[i][3];
				System.out.println("PW1" + PW1[i]);
				PE1[i] = dados_MT[i][4];
				System.out.println("PE1" + PE1[i]);
				PS1[i] = dados_MT[i][5];
				System.out.println("PS1" + PS1[i]);
				PC[i] = dados_MT[i][6];
				System.out.println("PC" + PC[i]);
				XKVA2[i] = dados_MT[i][7];
				System.out.println("XKVA2" + XKVA2[i]);
				THKVA2[i] = dados_MT[i][8];
				System.out.println("THKVA2" + THKVA2[i]);
				THEWA[i] = dados_MT[i][9];
				System.out.println("THEWA" + THEWA[i]);
				THEHSA[i] = dados_MT[i][10];
				System.out.println("THESA" + THEHSA[i]);
				THETOR[i] = dados_MT[i][11];
				System.out.println("THETOR" + THETOR[i]);
				THEBOR[i] = dados_MT[i][12];
				System.out.println("THEBOR" + THEBOR[i]);
				TAR[i] = dados_MT[i][13];
				System.out.println("TAR" + TAR[i]);
				MC[i] = dados_MT[i][14];
				System.out.println("MC" + MC[i]);
				PUELHS[i] = dados_MT[i][15];
				System.out.println("PUELHS" + PUELHS[i]);
				TAUW[i] = dados_MT[i][16];
				System.out.println("TAUW" + TAUW[i]);
				HHS[i] = dados_MT[i][17];
				System.out.println("HHS" + HHS[i]);
				WCC[i] = dados_MT[i][18];
				System.out.println("WCC" + WCC[i]);
				WTANK[i] = dados_MT[i][19];
				System.out.println("WTANK" + WTANK[i]);
				MF[i] = dados_MT[i][20];
				System.out.println("MF" + MF[i]);
				GFLUID[i] = dados_MT[i][21];
				System.out.println("GFLUID" + GFLUID[i]);
				MCORE[i] = dados_MT[i][22];
				System.out.println("MCORE" + MCORE[i]);
				TIMCOR[i] = dados_MT[i][23];
				System.out.println("TIMCOR" + TIMCOR[i]);
				PCOE[i] = dados_MT[i][24];
				System.out.println("PCOE" + PCOE[i]);
				LCAS[i] = dados_MT[i][25];
				System.out.println("LCAS" + LCAS[i]);
				MA[i] = dados_MT[i][26];
				System.out.println("MA" + MA[i]);
				MPR1[i] = dados_MT[i][27];
				System.out.println("MPR1" + MPR1[i]);				
			}
		}		
		
		ntrafo = XKVA1.length;
		System.out.println("valor do ntrafo - " + ntrafo);
		
		
		for(int i=0;i<=24;i++){
			TIM[i] = dados_TIM[0][i];
		}

		for(int i=0;i<=24;i++){
			System.out.println("TIM[" + i + "] - " + TIM[i]);
		}

		
		for(int i=0;i<1;i++){
			for(int j=0;j<=24;j++){
				AMB[i][j] = dados_temp[i][j];
			}
		}

		for(int i=0;i<1;i++){
			for(int j=0;j<=24;j++){
				System.out.println("AMB[" + i + "]" + "[" + j + "] - " + AMB[i][j]);
			}
		}
	    
		DTP=60;

	   
		for(int i=0;i<1;i++){
			for(int j=0;j<=24;j++){
				PUL[i][j] = dados_CC[i][j];
			}
		}

		for(int i=0;i<1;i++){
			for(int j=0;j<=24;j++){
				System.out.println("PUL[" + i + "]" + "[" + j + "] - " + PUL[i][j]);
			}
		}

		
		for(int i=0;i<1;i++){
			for(int j=0;j<dados_TIM.length;j++){
				JJ[i][j] = dados_TIM[i][j];
			}
		}

		for(int i=0;i<1;i++){
		  	for(int j=0;j<dados_TIM.length;j++){
		  		System.out.println("JJ[" + i + "][" + j + "] - " + JJ[i][j]);
		  	}
		}

		JJ[0][0] = JJ.length;
		System.out.println("Variavel JJ[0][0] - " + JJ[0][0]);
		double x, y;

		for(int m=0; m<JJ[0][0]; m++){
			x = 60 * TIM[m];
			TIM[m] = 0;
			TIM[m] = x;
			y = AMB[0][m];
			AMB[0][m] = y;
			PUL[0][m] = PUL[0][m]; //valores ja atribuidos
		}

		for(int m=0;m<JJ[0][0];m++){
			System.out.println("TIM "+TIM[m]);
			System.out.println("AMB "+AMB[0][m]);
			System.out.println("PUL " + PUL[0][m]); //valores ja atribuidos
		}
		
		if(MC[0] == 1){
			TK = 225;
			CPW = 6.798;
		}

		else if(MC[0] == 2){
			TK = 234.5;
			CPW = 2.91;
		}
		
		System.out.println("TK - " + TK);
		System.out.println("CPW - " + CPW);
		
		if(MF[0] == 1){
			CPF = 13.92;
			RHOF = 0.031621;
			C8 = 2797.3;
			B8 = 0.0013473;
		}
		else if(MF[0] ==2){
		    CPF=11.49;
		    RHOF=0.0347;
		    C8=1782.3;
		    B8=0.12127;
		}
		else if(MF[0] ==3){
			CPF=14.55;
		    RHOF=0.031781;
		    C8=4434.7;
		    B8=0.0000034;
		}
		
		System.out.println("CPF " + CPF);
		System.out.println("RHOF " + RHOF);
		System.out.println("C8 " + C8);
		System.out.println("B8 " + B8);
		
		switch ((int)MA[0]){
		
			case 1:
				X8=0.5;
				YN8=0.8;
				Z8=0.5;
				THEDOR=THETOR[0];

			case 2:
				X8=0.5;
				YN8=0.9;
				Z8=0.5;
				THEDOR=THETOR[0];

			case 3:
				X8=0.5;
				YN8=0.9;
				Z8=1;
				THEDOR=THEWA[0];

			case 4:
				X8=1;
				YN8=1;
				Z8=1;
				THEDOR=THETOR[0];
		}
		
		System.out.println("X8 - " + X8);
		System.out.println("YN8 - " + YN8);
		System.out.println("Z8 - " + Z8);
		System.out.println("THEDOR - " + THEDOR);
		
		TWR = TAR[0]+THKVA2[0];
		TWRT = TAR[0]+THEWA[0];
		THSR = TAR[0]+THEHSA[0];
		TTOR = TAR[0]+THETOR[0];
		TBOR = TAR[0]+THEBOR[0];
		TTDOR = THEDOR+TAR[0];
		TWOR = (HHS[0]*(TTDOR-TBOR))+TBOR;
		TDAOR = (TTDOR+TBOR)/2;
		TFAVER = (TTOR+TBOR)/2;
		
		System.out.println("TWR - " + TWR);
		System.out.println("TWRT - " + TWRT);
		System.out.println("THSR - " + THSR);
		System.out.println("TTOR - " + TTOR);
		System.out.println("TBOR - " + TBOR);
		System.out.println("TTDOR - " + TTDOR);
		System.out.println("TWOR - " + TWOR);
		System.out.println("TDAOR - " + TDAOR);
		System.out.println("TFAVER "+TFAVER);

		XK2 = Math.pow(XKVA2[0]/XKVA1[0], 2);
		TK2 = (TK+TWR)/(TK+TKVA1[0]);
		PW = (XK2*PW1[0]*TK2);
		PE = XK2*PE1[0]/TK2;
		PS = XK2*PS1[0]/TK2;
		PT = PW + PE + PS + PC[0];

		if(PE/PW > PUELHS[0]){
			PUELHS[0] = PE/PW;
		}

		TKHS=(THSR+TK)/(TWR+TK);
		PWHS=TKHS*PW;
		PEHS=PUELHS[0]*PWHS;

		System.out.println("PEHS " + PEHS);

		//System.out.println("MPR1" + MPR1[0]);
		if(MPR1[0] < 1){
			for(int i=0;i<1;i++){
				TIMCOR[i] = 60 * TIMCOR[i];
			}
		}

		DT = 0.5;

		while(TAUW[0]/DT < 9){
			DT = DT/2;
		}

		XMCP = (PE + PW)*TAUW[0] / (TWRT - TDAOR);
		WWIND = XMCP/CPW;

		System.out.println("aaaa --- " + WWIND);
		System.out.println("aaaa --- " + WCC[0]);

		if(WWIND < WCC[0]){
			WCORE = WCC[0] - WWIND;
			CPST = 3.51;
			WFL = GFLUID[0] * 231 * RHOF;
			SUMMCP = (WTANK[0] * CPST) + (WCORE * CPST) + (WFL * CPF);

			System.out.println("WCORE " + CPST);
			System.out.println("WFL " + WCORE);
			System.out.println("COPF " + WFL);




			T = (TWRT + TDAOR)/2;
			VISR = B8*Math.exp(C8/(T+273));
			T = (THSR + TWOR) / 2;
			VIHSR = B8*Math.exp(C8/(T+273));
			TMP = 0;
			
			System.out.println("T - " + T); 

			if(MPR1[0] < 1){
				DTP = 15;
			}

			KK = Math.round((TIM[(int)JJ[0][0]-1]/DTP) + 0.1); // nearest ten, 1730.0
			System.out.println(KK + "VALORES");
			int index;
			index = (int)KK;
			double[] TIMP = new double[index];
			for(K=0;K<(int)KK;K++){
				TMP = TMP+DTP;
				TIMP[K] = TMP;
			}

			for(K=0;K<(int)KK;K++){
				System.out.println("AQAQAQ"+TIMP[K]);
			}

			if(MPR1[0] == 1){
				System.out.println("HORAS	THS");
				System.out.println("HOURS	TEMP");
			}


			
			if(LCAS[0] == 1){
				THS = THSR;
				System.out.println("THS IIIIIIIIIIIIIIIIIIIIIIII " + THS);
				TW = TWRT;
				TTO = TTOR;
				TTDO = TTDOR;
				TBO = TBOR;
				MPR = 0;
				JLAST = 2;
				
			}
			else{
				MPR = MPR1[0];
				JLAST = 1;
				
			}
			//System.out.println("THS--------" + THS + "TW------" +TW);
			//System.out.println("AQUI FLAG:  " + flag);




			TFAVE = (TTO + TBO) / 2;
			TWO = TBO + (HHS[0] *(TTDO - TBO));
		    //System.out.println("TWO --- )))((( " + TWO);

			

			for(JJJ=0;JJJ<JLAST;JJJ=JJJ+1){
				if(JJJ == 1){
					MPR = MPR1[0];
				}
				THSMAX = THS;
				TTOMAX = TTO;
				J = 0;
				K = 0;
				TIMS = 0;
				TIMSH = 0;
				ASUM=0;
				if(MPR == 1){
					TIMSH_P[K]=TIMSH;
					//System.out.println("===" + TIMSH_P[K]);
					//PL_P[K-1] = PUL(:1);
					for(int i=0;i<=24;i++){
						for(int j=0;j<1;j++){
							PL_P[K]=PUL[i][j];
						}
					}
					//TA_P(K)=AMB(:,1);
					for(int i=0;i<=24;i++){
						for(int j=0;j<1;j++){
							TA_P[K] = AMB[i][j];
						}
					}
					THS_P[K]=THS;
					TTO_P[K]=TTO;
					TTDO_P[K]=TTDO;
					TBO_P[K]=TBO;
				}

				DTP = 60;
				//iter = 0;

				//System.out.println((int)JJ[0][0]);
				System.out.println(K+" - Antes do while");
				System.out.println("testeeee" + TIM[(int)JJ[0][0]-1]/DTP);
				while(K <= TIM[(int)JJ[0][0]-1]/DTP){

					System.out.println(K+" - Depois no while");
					System.out.println("valor N");
					System.out.println("valor do calculo" + TIM[(int)JJ[0][0]-1]/DTP);

					if(K>0){
					while (TIMS < TIMP[K-1]){
						TIMS = TIMS + DT;
						if(TIMS > TIM[J]){
							J = J + 1;
						}
						if(TIMS <= TIM[(int)JJ[0][0]-1]){
							if(Math.round(TIM[J] - TIM[J-1]) < .01){
								J = J + 1;
							}
							SL = (PUL[0][J] - PUL[0][J-1])/(TIM[J] - TIM[J-1]);
							PL = PUL[0][J-1] + (SL * (TIMS - TIM[J-1]));
							SLAMB = (AMB[0][J] - AMB[0][J-1])/(TIM[J] - TIM[J-1]);
							TA = AMB[0][J-1] + (SLAMB * (TIMS - TIM[J-1]));
							TDAO = (TTDO + TBO) / 2;
							TKW = (TW + TK) / (TWR + TK);
							QWGEN = PL * PL * ((TKW * PW) + (PE / TKW)) * DT;
							if(TW > TDAO){
								if(MA[0] < 4){
									T = (TW + TDAO) / 2;
									VIS = B8*Math.exp(C8/(T+273));
									QWLOST = Math.pow((TW - TDAO)/(TWRT - TDAOR), 1.25) * Math.pow(VISR/VIS, 0.25) * (PW + PE) * DT;

								}
								else{
									QWLOST = ((TW - TDAO)/(TWRT - TDAOR)) * (PW + PE) * DT;
								}

							}
							else{
								QWLOST = 0;
								if(TW < TBO){
									TW = TBO;
								}
							}
							TW = (QWGEN - QWLOST + (XMCP * TW)) / XMCP;
							DTDO = (TTDOR - TBOR) * Math.pow(QWLOST/((PW + PE) * DT), X8);
							TTDO = TBO + DTDO;
							TDAO = (TTDO + TBO)/2;
							TWO = TBO + (HHS[0] * DTDO);
							TKHS = (THS + TK) / (THSR + TK);
							if((TTDO + 0.1) < TTO){
								TWO = TTO;
							}
							//System.out.println("THS value - " + THS);
							//System.out.println("TW value - " + TW);
							if (THS < TW){
								THS = TW;
							}
							//System.out.println("THS value - " + THS);
							//System.out.println("TWO value - " + TWO);
							if(THS < TWO){
								THS = TWO;
							}
							
							QHSGEN = PL * PL * ((TKHS * PWHS) + (PEHS / TKHS)) * DT;
							if(MA[0] < 4){
								T = (THS + TWO) / 2;
								VISHS = B8 * Math.exp(C8/(T+273));
								QLHS = Math.pow((THS-TWO)/(THSR-TWOR), 1.25) * Math.pow(VIHSR/VISHS, .25) * (PWHS + PEHS) * DT;
								//System.out.println("THS " + THS + " THSR " + THSR + " VIHSR " + VIHSR + " VISHS " + VISHS + " PWHS " + PWHS + " PEHS " + PEHS);
							}
							else{
								
								QLHS = ((THS-TWO) / (THSR-TWOR)) * (PWHS+PEHS) * DT;
							}
							
							THS = (QHSGEN - QLHS + (XMCP * THS)) / XMCP;
							//System.out.println("QLHS ::: " + QLHS + " QHSGEN ::: " + QHSGEN + " XMCP ::: " + XMCP);
							//System.out.println("THS **** " +THS);
							QS = ((PL * PL * PS) / TKW) *DT;
							QLOSTF = Math.pow((TFAVE - TA) / (TFAVER - TAR[0]), 1/YN8) * PT * DT;

							if (MCORE[0] < 1){
								if(TIMS > TIMCOR[0]){
									QC = PCOE[0] * DT;
								}
								else{
									QC = PC[0] * DT;
								}
							}
							TFAVE = (QWLOST + QC + QS - QLOSTF + (SUMMCP*TFAVE)) / SUMMCP;
							DTTB = Math.pow(QLOSTF/(PT*DT),Z8)*(TTOR-TBOR);
							TTO = TFAVE + (DTTB / 2);
							TBO = TFAVE - (DTTB / 2);
							if(TBO < TA){
								TBO = TA;
							}

							if(TTDO < TBO){
								TTDO = TBO;
							}
							FAA = Math.exp((15000 / 383) - (15000 / (THS + 273)));
							ASUM = ASUM + (FAA * DT);
							//System.out.println(THS);
							//System.out.println("FAA " + FAA +" e DT " + DT);
							//System.out.println("ASUM -- " + ASUM);
							

							if (THS > THSMAX){
								THSMAX = THS;
							}
							if (TTO > TTOMAX){
								TTOMAX = TTO;
							}
						}
					}
					}
					K = K+1;
				}//while K <= (TIM(JJ)/DTP)

				//System.out.println("T - " + T);
				if(MPR==1){
					System.out.println(TIMSH + "--" + THS);
					TIMSH_P[K-1]=TIMSH;
					PL_P[K-1]=PL;
					TA_P[K-1]=TA;
					THS_P[K-1]=THS;
					TTO_P[K-1]=TTO;
					TTDO_P[K-1]=TTDO;
					TBO_P[K-1]=TBO;
				}

			}//for(JJJ...


		//if(WWIND < WCC...
		TIMS = TIMS - DT;
		ASUM = ASUM / 60;
		FEQA = ASUM;
		
		System.out.println("Fator Envelhecimento Equivalente = " + FEQA + "[HORAS]");
		System.out.println(XKVA1.length + "[HORAS]");
		}

	}
}
