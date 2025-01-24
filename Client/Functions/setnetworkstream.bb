Function setnetworkstream%(arg0%)
    network\Field4 = arg0
    If (arg0 = $00) Then
        flushnetwork()
    EndIf
    Return $00
End Function
