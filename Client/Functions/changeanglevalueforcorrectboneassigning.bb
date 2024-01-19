Function changeanglevalueforcorrectboneassigning%(arg0#)
    Local local0#
    If (180.0 >= arg0) Then
        local0 = arg0
    Else
        local0 = (-360.0 + arg0)
    EndIf
    Return (Int local0)
    Return $00
End Function
