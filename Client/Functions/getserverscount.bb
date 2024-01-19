Function getserverscount%(arg0%, arg1%)
    Local local0%
    Local local1.servers
    local0 = $00
    For local1 = Each servers
        If (((local1\Field0 = arg0) And (local1\Field15 = $00)) <> 0) Then
            If (arg1 = $01) Then
                If (local1\Field4 <> $00) Then
                    local0 = (local0 + $01)
                EndIf
            Else
                local0 = (local0 + $01)
            EndIf
        EndIf
    Next
    Return local0
    Return $00
End Function
