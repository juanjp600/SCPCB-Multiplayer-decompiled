Function isdoubleitem%(arg0%, arg1%)
    Local local0$
    If (((arg0 > $00) And (arg0 <> arg1)) <> 0) Then
        Select arg0
            Case wi\Field0
                local0 = getlocalstring("msg", "weartwo.gas")
            Case wi\Field5,wi\Field9
                local0 = getlocalstring("msg", "weartwo.nvg")
            Case i_268\Field0,i_714\Field0,i_1499\Field0
                local0 = getlocalstring("msg", "weartwo.scps")
        End Select
        createmsg(local0, 6.0)
        selecteditem = Null
        Return $01
    EndIf
    Return $00
    Return $00
End Function
