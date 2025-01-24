Function changeanglevalueforcorrectboneassigning#(arg0#)
    If (180.0 >= arg0) Then
        Return arg0
    EndIf
    Return (-360.0 + arg0)
    Return 0.0
End Function
