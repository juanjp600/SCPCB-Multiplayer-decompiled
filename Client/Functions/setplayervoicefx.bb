Function setplayervoicefx%(arg0.mp_player, arg1%, arg2%)
    If (arg0\Field36\Field2[arg1] <> arg2) Then
        If (arg0\Field36\Field1[arg1] <> $00) Then
            bass_channelremovefx(arg0\Field36\Field0[arg1], arg0\Field36\Field1[arg1])
        EndIf
        If (arg2 <> $FFFFFFFF) Then
            arg0\Field36\Field1[arg1] = bass_channelsetfx(arg0\Field36\Field0[arg1], arg2, $00)
        EndIf
        arg0\Field36\Field2[arg1] = arg2
    EndIf
    Return arg0\Field36\Field1[arg1]
    Return $00
End Function
