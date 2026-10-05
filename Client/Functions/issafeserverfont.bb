Function issafeserverfont%(arg0$)
    Local local0%
    Local local1$
    Local local2%
    If (((len(arg0) < $01) Or (len(arg0) > $40)) <> 0) Then
        Return $00
    EndIf
    For local0 = $01 To len(arg0) Step $01
        local1 = mid(arg0, local0, $01)
        local2 = asc(local1)
        If ((((((((local2 >= $30) And (local2 <= $39)) Or ((local2 >= $41) And (local2 <= $5A))) Or ((local2 >= $61) And (local2 <= $7A))) Or (local1 = " ")) Or (local1 = "-")) Or (local1 = "_")) = $00) Then
            Return $00
        EndIf
    Next
    Return $01
    Return $00
End Function
