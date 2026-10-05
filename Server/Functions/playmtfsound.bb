Function playmtfsound%(arg0%, arg1.npcs)
    Return $00
    If (arg1 <> Null) Then
        arg1\Field17 = playsound2(arg0, camera, arg1\Field4, 8.0, 1.0)
    EndIf
    If (selecteditem <> $00) Then
        ;bbFieldPtrAdd at _16385_fplaymtfsound:21, probably for an object of unknowable type
        ;bbFieldPtrAdd at _16385_fplaymtfsound:51, probably for an object of unknowable type
        If (((3.0 = eax_001A) And (0.0 < eax_0022)) <> 0) Then
            ;bbFieldPtrAdd at _16388_fplaymtfsound:12, probably for an object of unknowable type
            ;bbFieldPtrAdd at _16388_fplaymtfsound:18, probably for an object of unknowable type
            Select eax_002D
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
