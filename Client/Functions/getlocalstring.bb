Function getlocalstring$(arg0$, arg1$)
    Local local0$
    If (inibufferkeyexist_("Data\local.ini", arg0, arg1) <> 0) Then
        local0 = inigetbufferstring("Data\local.ini", arg0, arg1, ((arg0 + ",") + arg1))
        Return inigetbufferstring((lang\Field1 + "Data\local.ini"), arg0, arg1, local0)
    Else
        local0 = inigetbufferstring("Data\MP_local.ini", arg0, arg1, ((arg0 + ",") + arg1))
        Return inigetbufferstring((lang\Field1 + "Data\MP_local.ini"), arg0, arg1, local0)
    EndIf
    Return ""
End Function
