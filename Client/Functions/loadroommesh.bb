Function loadroommesh%(arg0.roomtemplates)
    If (fileextension(arg0\Field2) = "rmesh") Then
        arg0\Field0 = loadrmesh(arg0\Field2, arg0, $01)
    ElseIf (fileextension(arg0\Field2) = "b3d") Then
        runtimeerrorex(format(getlocalstring("runerr", "b3d"), arg0\Field2, "%s"))
    Else
        runtimeerrorex(format(getlocalstring("runerr", "notfound"), arg0\Field2, "%s"))
    EndIf
    If (arg0\Field0 = $00) Then
        runtimeerrorex(format(getlocalstring("runerr", "failedload"), arg0\Field2, "%s"))
    EndIf
    calculateroomtemplateextents(arg0)
    hideentity(arg0\Field0)
    Return $00
End Function
