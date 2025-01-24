Function loadanimmesh_strict%(arg0$, arg1%)
    Local local0%
    Local local1%
    Local local2%
    Local local3%
    Local local4%
    Local local5%
    Local local6%
    Local local7%
    local6 = $00
    If (local0 = $00) Then
        If (filetype(arg0) <> $01) Then
            runtimeerrorex(format(getlocalstring("runerr", "animmesh.notfound"), arg0, "%s"))
        EndIf
        local0 = loadanimmesh(arg0, arg1)
        If (local0 = $00) Then
            runtimeerrorex(format(getlocalstring("runerr", "animmesh.failed.load"), arg0, "%s"))
        EndIf
    EndIf
    local7 = countsurfaces(local0)
    For local1 = $01 To local7 Step $01
        local2 = getsurface(local0, local1)
        local3 = getsurfacebrush(local2)
        If (local3 <> $00) Then
            local5 = $00
            local4 = $00
            local4 = getbrushtexture(local3, $00)
            If (local4 <> $00) Then
                local6 = istexalpha(local4, "")
                local5 = checkfortexture(local4, local6)
                If (local5 <> $00) Then
                    brushtexture(local3, local5, $00, $00)
                    deletesingletextureentryfromcache(local5, $00)
                    local5 = $00
                Else
                    brushtexture(local3, missingtexture, $00, $00)
                EndIf
                paintsurface(local2, local3)
                freetexture(local4)
                local4 = $00
            EndIf
            freebrush(local3)
            local3 = $00
        EndIf
    Next
    Return local0
    Return $00
End Function
