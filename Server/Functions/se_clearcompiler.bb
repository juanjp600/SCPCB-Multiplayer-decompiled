Function se_clearcompiler%()
    Local local0.se_constantdef
    Delete Each se_line
    Delete Each se_token
    Delete Each se_node
    Delete Each se_chunk
    Delete Each se_block
    For local0 = Each se_constantdef
        If (local0\Field3 = $00) Then
            Delete local0
        EndIf
    Next
    Delete Each se_localdef
    Delete Each se_staticdef
    Delete Each se_globaldef
    Delete Each se_publicdef
    Delete Each se_functiondef
    Delete Each se_tempvalue
    Delete Each se_blockspace
    se_vf_closefile()
    Return $00
End Function
