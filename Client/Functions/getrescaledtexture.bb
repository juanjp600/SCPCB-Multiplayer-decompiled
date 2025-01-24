Function getrescaledtexture%(arg0$, arg1%, arg2%, arg3%, arg4%)
    Local local0%
    Local local1%
    Local local2%
    Local local3$
    Local local4%
    If (filetype((lang\Field1 + arg0)) = $01) Then
        arg0 = (lang\Field1 + arg0)
    EndIf
    local0 = fi_getfiffromfilename(arg0)
    local1 = fi_load(local0, arg0, arg1)
    local2 = fi_rescale(local1, arg2, arg3, $00)
    local3 = ((getenv("Temp") + "\") + strippath(arg0))
    fi_save(local0, local2, local3, arg1)
    If (arg4 <> 0) Then
        local4 = loadbrush_strict(local3, arg1, 1.0, 1.0)
    Else
        local4 = loadtexture_strict(local3, arg1, $00, $01)
    EndIf
    fi_unload(local1)
    local1 = $00
    fi_unload(local2)
    local2 = $00
    deletefile(local3)
    Return local4
    Return $00
End Function
