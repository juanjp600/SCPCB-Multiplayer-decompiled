Function playeriscidrbanned%(arg0$)
    Local local0.cidrs
    For local0 = Each cidrs
        If (checkcidrrange(arg0, local0\Field0) <> 0) Then
            Return $01
        EndIf
    Next
    Return $00
    Return $00
End Function
