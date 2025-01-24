Function receiveplayervoice%(arg0.mp_player, arg1%, arg2%)
    arg0\Field28 = max(rnd(2.0, 4.0), arg0\Field28)
    arg0\Field25 = calculateplayeradjacency(ue_players[mp_getmyindex()], arg0)
    If (180.0 > entitydistancesquared(arg0\Field18, me\Field60)) Then
        If (0.25 > arg0\Field25) Then
            bass_fxsetdistortion(setplayervoicefx(arg0, $00, $02), -20.7679, 0.793402, 269.81, 222.92, 200.041)
        Else
            setplayervoicefx(arg0, $00, $FFFFFFFF)
        EndIf
        bass_opus_streamputdata(arg0\Field36\Field0[$00], arg1, banksize(arg1))
    EndIf
    If (((arg2 > $00) And (arg2 = myplayerlogic\Field2)) <> 0) Then
        bass_opus_streamputdata(arg0\Field36\Field0[$01], arg1, banksize(arg1))
    EndIf
    setplayertagtext(arg0, $01, "A")
    setplayervoiceinactive(arg0, $12C)
    Return $00
End Function
