Function opendatabase%(arg0$, arg1%, arg2%, arg3%)
    Local local0%
    Local local2.databasehandlecontainer
    Local local3%
    Local local4%
    local0 = (filetype(arg0) = $01)
    Select arg1
        Case $01
            If (local0 = $00) Then
                Return sqlite3_errorhasoccurred("OpenDatabase", arg3, (("the specified database file (" + arg0) + ") does not exist"))
            EndIf
        Case $02
            If (local0 <> 0) Then
                deletefile(arg0)
            EndIf
    End Select
    local2 = (New databasehandlecontainer)
    local3 = sqlite3_open(arg0, local2)
    local4 = local2\Field0
    Delete local2
    If (local3 = $00) Then
        If (arg2 <> 0) Then
            currentdatabasehandle = local4
        EndIf
        Return local4
    Else
        sqlite3_errorhasoccurred("OpenDatabase", arg3, "")
    EndIf
    Return $00
End Function
