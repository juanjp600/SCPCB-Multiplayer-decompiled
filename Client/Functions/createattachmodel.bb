Function createattachmodel.mp_attachmodel(arg0%, arg1$, arg2$, arg3%)
    If (((attachmodels[arg0] <> Null) Lor (arg0 = $00)) <> 0) Then
        Return Null
    EndIf
    attachmodels[arg0] = (New mp_attachmodel)
    attachmodels[arg0]\Field0 = arg0
    attachmodels[arg0]\Field5 = arg3
    setattachmodelvariety(arg0, $00, arg1, arg2)
    Return attachmodels[arg0]
    Return Null
End Function
