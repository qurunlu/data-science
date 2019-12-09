imagP=imread('/homes/r18qu/Bureau/L/S2/elu510/moi/challenge_3/population-density-map.bmp');
figure(1);
subplot(2,1,1);
imshow(P);
hold on 
E=imread('/homes/r18qu/Bureau/L/S2/elu510/moi/challenge_3/fuckzombies.bmp');
subplot(2,1,2);
imshow(E);
N=cpselect(E,imagP);
tform = cp2tform(movingPoints,fixedPoints,'polynomial');
info1 = imfinfo('/homes/r18qu/Bureau/L/S2/elu510/moi/challenge_3/population-density-map.bmp');
NB = imtransform(E,tform,...
'XData',[1 info1.Width],'YData',[1 info1.Height]);
imshow(NB);
imwrite(NB,'/homes/r18qu/Bureau/L/S2/elu510/moi/challenge_3/resultNB1.bmp');


x=imread('/homes/r18qu/Bureau/L/S2/elu510/moi/challenge_3/resultNB.jpg');
imshow(x);
mycolorpoint=[[1,186,253];[141,172,102];[145,179,119];[161,195,134];[198,213,145];[213,221,161];[182,144,121];[159,101,100]; [173,128,122]];
%mycolorpoint=[[1,186,253];[39,187,215];[136,185,120];[173,128,122]];
mycolorposition=[0 50 80 110 500 1000 1500 3500 4810];

mycolormap_r=interp1(mycolorposition,mycolorpoint(:,1),0:4810,'linear','extrap');
mycolormap_g=interp1(mycolorposition,mycolorpoint(:,2),0:4810,'linear','extrap');
mycolormap_b=interp1(mycolorposition,mycolorpoint(:,3),0:4810,'linear','extrap');

mycolor=[[mycolormap_r],[mycolormap_g],[mycolormap_b]];
color1=round(mycolor,2);
figure(1);
load flujet;
image(x);
colormap mycolorpoint



movingPoints =

   1.0e+03 *

    0.3866    3.6823
    0.1465    3.4743
    0.1625    3.2782
    0.3626    2.8221
    1.2828    3.2662
    0.9627    3.5383
    1.7709    3.4103
    1.7789    3.0702
    2.2950    3.8143
    1.8829    3.9024
    1.8589    4.1144
    1.2868    3.4783
    0.9427    2.9982
    2.1869    2.9622
    2.5310    3.6383
    2.3510    3.4183
    4.1022    2.6324
    3.5818    2.8165
    3.7619    3.0326
    4.4464    3.2008
    3.9100    3.2648
    3.8140    2.8325
    3.2255    3.5370
    3.9821    3.9733
    3.4177    3.9893
    2.2288    3.9893
    2.9534    4.0333
    3.2896    3.3208
    4.1102    3.8292
    1.3948    2.1900
    2.1229    1.6219
    2.1389    1.4379
    2.6190    1.4099
    2.6190    1.6379
    3.2432    1.3618
    2.9031    1.7339
    2.6390    2.0380
    2.3670    1.9460
    2.1069    2.0460
    1.6868    2.1100
    0.8907    2.1980
    0.9267    1.9460
    1.0987    1.8099
    1.3628    1.3618
    1.8909    1.5179
    2.8711    1.5339
    2.5670    1.9860
    1.6868    2.0380
    1.5508    1.1538
    1.1867    1.2858

fixedPoints

fixedPoints =

   1.0e+03 *

    0.5303    2.6771
    0.2464    2.5532
    0.2064    2.3732
    0.2424    1.8814
    1.2860    2.0214
    1.0421    2.3652
    1.8018    2.0814
    1.7378    1.7295
    2.3535    2.4212
    1.9857    2.5612
    1.9977    2.7731
    1.3579    2.2253
    0.8821    1.8375
    2.1296    1.6056
    2.5814    2.2373
    2.3695    2.0214
    4.1025    1.4433
    3.5061    1.4954
    3.7823    1.7515
    4.4947    2.0477
    3.9544    1.9996
    3.7903    1.5954
    3.2660    2.1717
    4.0865    2.7000
    3.4981    2.6120
    2.3335    2.6040
    3.0419    2.6520
    3.2900    1.9476
    4.1705    2.6160
    1.1420    1.0018
    1.7658    0.3501
    1.7218    0.1822
    2.2696    0.1582
    2.3215    0.3261
    2.9013    0.1462
    2.6374    0.4300
    2.4015    0.6899
    2.0896    0.6420
    1.8297    0.7179
    1.4219    0.8699
    0.5823    1.1378
    0.5583    0.9338
    0.6862    0.7259
    0.8941    0.3621
    1.4499    0.3261
    2.5734    0.2421
    2.3335    0.6420
    1.3619    0.8019
    0.9821    0.0742
    0.6102    0.2861

