Function mp_client_receiveitemsdata%()
    Local local0%
    Local local1.items
    Repeat
        local0 = mp_readshort()
        If (((local0 = $00) Lor (local0 > $3E8)) <> 0) Then
            Exit
        EndIf
        mp_client_receiveitem(local0)
    Forever
    For local1 = Each items
        If (((local1\Field28 = $00) And (0.0 >= local1\Field31)) <> 0) Then
            removeitem(local1)
        Else
            mp_client_analyzeitem(local1, $00)
            local1\Field28 = $00
        EndIf
    Next
    Return $00
End Function
