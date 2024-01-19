Function playmtfsound%(arg0%, arg1.npcs)
    If (arg1 <> Null) Then
        arg1\Field17 = playsound2(arg0, camera, arg1\Field4, 8.0, 1.0)
    EndIf
    If (selecteditem <> Null) Then
        If (((3.0 = selecteditem\Field14) And (0.0 < selecteditem\Field13)) <> 0) Then
            Select selecteditem\Field3\Field2
                Case "radio","fineradio","18vradio"
                    If (((arg0 <> mtfsfx($05)) Or (channelplaying(radiochn($03)) = $00)) <> 0) Then
                        If (radiochn($03) <> $00) Then
                            stopchannel(radiochn($03))
                        EndIf
                        radiochn($03) = playsound_strict(arg0)
                    EndIf
            End Select
        EndIf
    EndIf
    Return $00
End Function
