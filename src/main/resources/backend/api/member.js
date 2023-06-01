function getDrugsList (params) {
  return $axios({
    url: '/drugs/page',
    method: 'get',
    params
  })
}

// 修改---启用禁用接口
function enableOrDisableEmployee (params) {
  return $axios({
    url: '/drugs',
    method: 'put',
    data: { ...params }
  })
}

// 新增---添加药物
function addDrugs (params) {
  return $axios({
    url: '/drugs',
    method: 'post',
    data: { ...params }
  })
}

// 修改---添加药物
function editDrugs (params) {
  return $axios({
    url: '/drugs',
    method: 'put',
    data: { ...params }
  })
}

// 修改页面反查详情接口
function queryDrugsById (drugbankid) {
  return $axios({
    url: `/drugs/${drugbankid}`,
    method: 'get'
  })
}