Function gg_create_text_line.tgg_textline(arg0$, arg1%, arg2#, arg3%, arg4%)
    Local local0%
    Local local1%
    Local local2%
    Local local3.tgg_textline
    Local local4.tgg_character
    Local local5%
    Local local6%
    Local local7%
    If (gg_ocurrent_font = Null) Then
        runtimeerror("GG_Create_Text_Line() was called without a current GG bitmap font.")
    EndIf
    If (arg1 < $FFFFFFFF) Then
        arg1 = $FFFFFFFF
    EndIf
    local3 = (New tgg_textline)
    local3\Field1 = arg0
    local3\Field0 = createpivot(arg4)
    local3\Field5 = arg1
    local3\Field6 = arg2
    local3\Field7 = arg3
    local7 = $00
    For local0 = $01 To len(arg0) Step $01
        If (local0 > $FA) Then
            Exit
        EndIf
        local4 = gg_find_character(gg_ocurrent_font, mid(arg0, local0, $01))
        If (local4 <> Null) Then
            local3\Field2[(local0 - local7)] = copyentity(local4\Field4, local3\Field0)
            showentity(local3\Field2[(local0 - local7)])
        Else
            local7 = (local7 + $01)
        EndIf
    Next
    local3\Field4 = local4\Field1
    gg_space_text_line(local3, arg0)
    Return local3
    Return Null
End Function
