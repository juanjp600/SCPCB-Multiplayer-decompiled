Function loadmesh_strict%(arg0$, arg1%)
    Local local0%
    Local local1%
    Local local2%
    Local local3%
    Local local4%
    Local local5%
    Local local6%
    Local local7%
    Local local8%
    local7 = $00
    If (local0 = $00) Then
        If (filetype(arg0) <> $01) Then
            runtimeerrorex(format(getlocalstring("runerr", "mesh.notfound"), arg0, "%s"))
        EndIf
        local0 = loadmesh(arg0, arg1)
        If (local0 = $00) Then
            runtimeerrorex(format(getlocalstring("runerr", "mesh.failed.load"), arg0, "%s"))
        EndIf
    EndIf
    local8 = countsurfaces(local0)
    For local1 = $01 To local8 Step $01
        local2 = getsurface(local0, local1)
        local3 = getsurfacebrush(local2)
        If (local3 <> $00) Then
            local6 = $00
            local4 = $00
            local5 = $00
            local4 = getbrushtexture(local3, $00)
            If (local4 <> $00) Then
                local7 = istexalpha(local4, "")
                If (local7 <> $02) Then
                    local6 = checkfortexture(local4, local7)
                    If (local6 <> $00) Then
                        brushtexture(local3, local6, $00, $00)
                        deletesingletextureentryfromcache(local6, $00)
                        local6 = $00
                    Else
                        brushtexture(local3, missingtexture, $00, $00)
                    EndIf
                Else
                    local6 = checkfortexture(local4, $01)
                    If (local6 <> $00) Then
                        texturecoords(local6, $01)
                        brushtexture(local3, local6, $00, $00)
                        deletesingletextureentryfromcache(local6, $00)
                        local6 = $00
                    Else
                        brushtexture(local3, missingtexture, $00, $00)
                    EndIf
                    local5 = getbrushtexture(local3, $01)
                    If (local5 <> $00) Then
                        local6 = checkfortexture(local5, local7)
                        If (local6 <> $00) Then
                            texturecoords(local6, $00)
                            brushtexture(local3, local6, $00, $01)
                            deletesingletextureentryfromcache(local6, $00)
                            local6 = $00
                        Else
                            brushtexture(local3, missingtexture, $00, $01)
                        EndIf
                        freetexture(local5)
                        local5 = $00
                    EndIf
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
