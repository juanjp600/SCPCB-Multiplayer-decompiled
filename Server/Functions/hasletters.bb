Function hasletters%(arg0$)
    Local local0%
    Local local1%
    For local0 = $01 To len(arg0) Step $01
        local1 = asc(mid(arg0, local0, $01))
        If ((((local1 >= $41) And (local1 <= $5A)) Or ((local1 >= $61) And (local1 <= $7A))) <> 0) Then
            Return $01
        EndIf
    Next
    Return $00
    Return $00
End Function
