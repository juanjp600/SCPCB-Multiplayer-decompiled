Function getplayerattachpreset.mp_attachmodelpreset(arg0.mp_playermodel, arg1.mp_attachmodel)
    If (arg0\Field17 >= $00) Then
        Return arg1\Field9[arg0\Field17]
    EndIf
    Return Null
    Return Null
End Function
