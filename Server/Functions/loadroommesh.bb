Function loadroommesh%(arg0.roomtemplates)
    Local local0%
    If (instr(arg0\Field2, ".rmesh", $01) <> $00) Then
        arg0\Field0 = loadrmesh(arg0\Field2, arg0)
    ElseIf (arg0\Field2 <> "") Then
        arg0\Field0 = loadworld(arg0\Field2, arg0)
    Else
        arg0\Field0 = createpivot($00)
    EndIf
    If (arg0\Field0 = $00) Then
        runtimeerror((((("Failed to load map file " + chr($22)) + (Str local0)) + chr($22)) + "."))
    EndIf
    calculateroomtemplateextents(arg0)
    hideentity(arg0\Field0)
    Return $00
End Function
