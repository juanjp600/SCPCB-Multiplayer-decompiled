Function playmtfsound%(arg0%, arg1.npcs)
    If (arg1 <> Null) Then
        arg1\Field18 = playsoundex(arg0, camera, arg1\Field3, 8.0, 1.0, $01, $00)
    EndIf
    If (isusingradio <> 0) Then
        If (((3.0 = selecteditem\Field13) And (0.0 < selecteditem\Field12)) <> 0) Then
            If (((arg0 <> npcsound[$00]) Lor (channelplaying(radiochn[$03]) = $00)) <> 0) Then
                stopchannel(radiochn[$03])
                radiochn[$03] = $00
                radiochn[$03] = playsound_strict(arg0, $01)
            EndIf
        EndIf
    EndIf
    Return $00
End Function
