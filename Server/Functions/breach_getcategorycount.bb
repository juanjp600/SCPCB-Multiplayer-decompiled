Function breach_getcategorycount%(arg0%)
    Local local0%
    Local local1%
    For local1 = $01 To server\Field11 Step $01
        If (breach_getcategorybytype(playeroptimize[local1]\Field36, $01) = arg0) Then
            local0 = (local0 + $01)
        EndIf
    Next
    Return local0
    Return $00
End Function
