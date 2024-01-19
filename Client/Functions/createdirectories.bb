Function createdirectories%(arg0$)
    Local local0%
    For local0 = $01 To len(arg0) Step $01
        If (((mid(arg0, local0, $01) = "\") Or (mid(arg0, local0, $01) = "/")) <> 0) Then
            If (filetype(left(arg0, (local0 - $01))) <> $02) Then
                createdir(left(arg0, (local0 - $01)))
            EndIf
        EndIf
    Next
    Return $00
End Function
