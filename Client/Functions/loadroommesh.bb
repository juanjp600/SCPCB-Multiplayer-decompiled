Function loadroommesh%(arg0.roomtemplates, arg1$)
    Local local0%
    If (arg1 = "") Then
        arg1 = arg0\Field2
    EndIf
    If (instr(arg1, ".rmesh", $01) <> $00) Then
        arg0\Field0 = loadrmesh(arg1, arg0)
    ElseIf (arg1 <> "") Then
        arg0\Field0 = loadworld(arg1, arg0)
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
